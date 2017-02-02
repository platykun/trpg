package com.trpg.scenario;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;

import com.trpg.entity.CharacterInfo;
import com.trpg.entity.Item;
import com.trpg.entity.ItemRepository;
import com.trpg.entity.RelatedCharacterRepository;
import com.trpg.entity.Scenario;
import com.trpg.entity.ScenarioRepository;
import com.trpg.entity.Scene;
import com.trpg.entity.SceneRepository;

@Controller
public class ScenarioAction {

	/** キャラクター情報テーブルのカテゴリ：NPC */
	public static final int RC_CATEGORY_NPC = 1;
	/** キャラクター情報テーブルのカテゴリ：ENEMY */
	public static final int RC_CATEGORY_ENEMY = 2;

	@Autowired
	ScenarioRepository scenarioRepository;
	@Autowired
	RelatedCharacterRepository relatedCharacterRepository;
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	ResourceLoader resourceLoader;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	SceneRepository sceneRepository;

	private static final RowMapper<CharacterInfo> characterInfoRowMapper = (rs, i) -> {
		CharacterInfo characterInfo = new CharacterInfo();
		characterInfo.setId(rs.getInt("id"));
		characterInfo.setName(rs.getString("name"));
		return characterInfo;
	};

	private static final RowMapper<ItemForm> itemFormRowMapper = (rs, i) -> {
		ItemForm item = new ItemForm();
		item.setId(rs.getInt("id"));
		item.setScenarioId(rs.getInt("scenario_id"));
		item.setSceneId(rs.getInt("scene_id"));
		item.setSerialNum(rs.getInt("serial_num"));
		item.setName(rs.getString("name"));
		item.setImgUrl(rs.getString("img_url"));
		item.setText(rs.getString("text"));
		return item;
	};

	private static final RowMapper<SceneForm> sceneFormRowMapper = (rs, i) -> {
		SceneForm scene = new SceneForm();
		scene.setId(rs.getInt("id"));
		scene.setScenarioId(rs.getInt("scenario_id"));
		scene.setSerialNum(rs.getInt("serial_num"));
		scene.setSceneGroup(rs.getInt("scene_group"));
		scene.setTitle(rs.getString("title"));
		scene.setOutline(rs.getString("outline"));
		scene.setText(rs.getString("text"));
		List<Integer> characterIds = new ArrayList<Integer>();
		int ap1 = rs.getInt("appear_character1");
		if (ap1 > 0)
			characterIds.add(Integer.valueOf(ap1));
		int ap2 = rs.getInt("appear_character2");
		if (ap2 > 0)
			characterIds.add(Integer.valueOf(ap2));
		int ap3 = rs.getInt("appear_character3");
		if (ap3 > 0)
			characterIds.add(Integer.valueOf(ap3));
		int ap4 = rs.getInt("appear_character4");
		if (ap4 > 0)
			characterIds.add(Integer.valueOf(ap4));
		int ap5 = rs.getInt("appear_character5");
		if (ap5 > 0)
			characterIds.add(Integer.valueOf(ap5));
		scene.setAppearCharacters(characterIds);
		List<Integer> sceneLinkIds = new ArrayList<Integer>();
		int sl1 = rs.getInt("scene_link_id1");
		if (sl1 > 0)
			sceneLinkIds.add(Integer.valueOf(sl1));
		int sl2 = rs.getInt("scene_link_id2");
		if (sl2 > 0)
			sceneLinkIds.add(Integer.valueOf(sl2));
		int sl3 = rs.getInt("scene_link_id3");
		if (sl3 > 0)
			sceneLinkIds.add(Integer.valueOf(sl3));
		int sl4 = rs.getInt("scene_link_id4");
		if (sl4 > 0)
			sceneLinkIds.add(Integer.valueOf(sl4));
		int sl5 = rs.getInt("scene_link_id5");
		if (sl5 > 0)
			sceneLinkIds.add(Integer.valueOf(sl5));
		scene.setSceneLinkIds(sceneLinkIds);
		return scene;
	};

	/**
	 * シナリオの一覧を取得する。
	 * 
	 * @return シナリオ一覧
	 */
	List<Scenario> getScenarioList() {
		return scenarioRepository.findAll();
	}

	/**
	 * シナリオの詳細を取得する。
	 * 
	 * @param id シナリオID
	 * @return シナリオの詳細
	 */
	ScenarioDetail getScenarioDetail(int id) {

		// NPCと敵の一覧を取得するためのSQL
		String getCharacterSQL = "SELECT * FROM character_info c WHERE EXISTS"
				+ "(SELECT character_info_id FROM related_character rc "
				+ "WHERE rc.scenario_id = :id AND rc.CATEGORY = :category AND c.id = rc.character_info_id)";

		// アイテムをシナリオIDから取得するためのSQL
		String getItemSQL = "SELECT * FROM item where SCENARIO_ID = :id";

		// シーンをシナリオIDから取得するためのSQL
		String getSceneSQL = "SELECT * FROM scene where SCENARIO_ID = :id";

		Scenario scenario = scenarioRepository.getOne(id);
		ScenarioDetail detail = new ScenarioDetail(scenario);

		// NPCを検索してformクラスへ格納する。
		SqlParameterSource npcParam = new MapSqlParameterSource().addValue("id", id).addValue("category",
				RC_CATEGORY_NPC);
		List<CharacterInfo> npcs = jdbcTemplate.query(getCharacterSQL, npcParam, characterInfoRowMapper);
		detail.setNpcs(npcs);
		// ENEMYを検索してformクラスへ格納する。
		SqlParameterSource enemyParam = new MapSqlParameterSource().addValue("id", id).addValue("category",
				RC_CATEGORY_ENEMY);
		List<CharacterInfo> enemies = jdbcTemplate.query(getCharacterSQL, enemyParam, characterInfoRowMapper);
		detail.setEnemies(enemies);

		// itemを取得してformクラスへ格納する。
		SqlParameterSource itemParam = new MapSqlParameterSource().addValue("id", id);
		List<ItemForm> items = jdbcTemplate.query(getItemSQL, itemParam, itemFormRowMapper);
		detail.setItems(items);

		// sceneを取得してformクラスへ格納する。
		SqlParameterSource sceneParam = new MapSqlParameterSource().addValue("id", id);
		List<SceneForm> scenes = jdbcTemplate.query(getSceneSQL, sceneParam, sceneFormRowMapper);

		// テーブルから取得したシーンIDをもとにシーン名を格納する。
		// TODO: やりかたはもうちょっとちゃんと考える
		for (SceneForm scene : scenes) {
			List<String> characterNameList = new ArrayList<String>();
			for (Integer characterId : scene.getAppearCharacters()) {
				if (characterId.equals(0))
					break;
				String name = scenes.stream().filter(s -> s.getId() == characterId.intValue()).findFirst().get()
						.getTitle();
				characterNameList.add(name);
			}
			scene.setAppearCharacterNames(characterNameList);
		}

		detail.setScenes(scenes);

		return detail;
	}

	/**
	 * formに格納された値をもとにデータを登録する。
	 * 
	 * @param form
	 */
	public void registScenario(ScenarioCreateForm form) {

		// シナリオをDBに登録する。
		Scenario createdScenario = scenarioRepository.save(convertToScenario(form));

		// 将来的にキャラクターの作成処理を行う。

		// itemをDBに登録する。
		List<ItemForm> items = form.getItems();

		if (items != null) {
			// アイテムのIDを設定する。
			int i = 1;
			for (ItemForm item : items) {
				item.setScenarioId(createdScenario.getId());
				item.setSerialNum(i);
				i++;
			}

			items.stream().forEach(item -> itemRepository.save(convertToItem(item)));
		}
		// シーンを登録する。
		List<SceneForm> scenes = form.getScenes();
		if (scenes != null) {
			scenes.stream().forEach(s -> sceneRepository.save(convertToScene(s)));
		}
	}

	/**
	 * アイテムフォームからアイテムエンティティオブジェクトへ変換する。
	 * 
	 * @param form アイテムフォーム
	 * @return アイテムエンティティ
	 */
	private Item convertToItem(ItemForm form) {
		Item item = new Item();
		item.setScenarioId(form.getScenarioId());
		item.setSceneId(form.getSceneId());
		item.setSerialNum(form.getSerialNum());
		item.setImgUrl(form.getImgUrl());
		item.setText(form.getText());
		return item;
	}

	private Scenario convertToScenario(ScenarioCreateForm form) {
		Scenario scenario = new Scenario();
		scenario.setTitle(form.getTitle());
		scenario.setOutline(form.getOutline());
		scenario.setRecommendPlayer(form.getRecommendPlayer());
		scenario.setTime(form.getTime());
		scenario.setText(form.getText());
		return scenario;
	}

	private Scene convertToScene(SceneForm form) {
		// formからsceneへ変換させる
		return null;
	}
}

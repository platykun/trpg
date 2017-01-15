package com.trpg.scenario;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import com.trpg.entity.RelatedCharacterRepository;
import com.trpg.entity.Scenario;
import com.trpg.entity.ScenarioRepository;

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
		scene.setAppearCharacter1(rs.getInt("appear_character1"));
		scene.setAppearCharacter2(rs.getInt("appear_character2"));
		scene.setAppearCharacter3(rs.getInt("appear_character3"));
		scene.setAppearCharacter4(rs.getInt("appear_character4"));
		scene.setAppearCharacter5(rs.getInt("appear_character5"));
		scene.setSceneLinkId1(rs.getInt("scene_link_id1"));
		scene.setSceneLinkId2(rs.getInt("scene_link_id2"));
		scene.setSceneLinkId3(rs.getInt("scene_link_id3"));
		scene.setSceneLinkId4(rs.getInt("scene_link_id4"));
		scene.setSceneLinkId5(rs.getInt("scene_link_id5"));
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
	 * @param id
	 *            シナリオID
	 * @return シナリオの詳細
	 */
	ScenarioDetail getScenarioDetail(int id) {

		//NPCと敵の一覧を取得するためのSQL
		String getCharacterSQL = "SELECT * FROM character_info c WHERE EXISTS"
				+ "(SELECT character_info_id FROM related_character rc "
				+ "WHERE rc.scenario_id = :id AND rc.CATEGORY = :category AND c.id = rc.character_info_id)";

		//アイテムをシナリオIDから取得するためのSQL
		String getItemSQL = "SELECT * FROM item where SCENARIO_ID = :id";

		//シーンをシナリオIDから取得するためのSQL
		String getSceneSQL = "SELECT * FROM scene where SCENARIO_ID = :id";

		Scenario scenario = scenarioRepository.getOne(id);
		ScenarioDetail detail = new ScenarioDetail(scenario);

		//NPCを検索してformクラスへ格納する。
		SqlParameterSource npcParam = new MapSqlParameterSource().addValue("id", id).addValue("category",
				RC_CATEGORY_NPC);
		List<CharacterInfo> npcs = jdbcTemplate.query(getCharacterSQL, npcParam, characterInfoRowMapper);
		detail.setNpcs(npcs);
		//ENEMYを検索してformクラスへ格納する。
		SqlParameterSource enemyParam = new MapSqlParameterSource().addValue("id", id).addValue("category",
				RC_CATEGORY_ENEMY);
		List<CharacterInfo> enemies = jdbcTemplate.query(getCharacterSQL, enemyParam, characterInfoRowMapper);
		detail.setEnemies(enemies);

		//itemを取得してformクラスへ格納する。
		SqlParameterSource itemParam = new MapSqlParameterSource().addValue("id", id);
		List<ItemForm> items = jdbcTemplate.query(getItemSQL, itemParam, itemFormRowMapper);
		detail.setItems(items);

		//sceneを取得してformクラスへ格納する。
		SqlParameterSource sceneParam = new MapSqlParameterSource().addValue("id", id);
		List<SceneForm> scenes = jdbcTemplate.query(getSceneSQL, sceneParam, sceneFormRowMapper);
		detail.setScenes(scenes);

		return detail;
	}

}

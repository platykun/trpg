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

	public static final int RC_CATEGORY_NPC = 1;
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
		String getCharacterSQL = "SELECT * FROM character_info c WHERE EXISTS"
				+ "(SELECT character_info_id FROM related_character rc "
				+ "WHERE rc.scenario_id = :id AND rc.CATEGORY = :category AND c.id = rc.character_info_id)";
		ScenarioDetail detail = new ScenarioDetail();
		detail.setScenario(scenarioRepository.findOne(id));

		SqlParameterSource npcParam = new MapSqlParameterSource().addValue("id", id).addValue("category",
				RC_CATEGORY_NPC);
		List<CharacterInfo> npcs = jdbcTemplate.query(getCharacterSQL, npcParam, characterInfoRowMapper);
		detail.setNpcs(npcs);

		SqlParameterSource enemyParam = new MapSqlParameterSource().addValue("id", id).addValue("category",
				RC_CATEGORY_ENEMY);
		List<CharacterInfo> enemies = jdbcTemplate.query(getCharacterSQL, enemyParam, characterInfoRowMapper);
		detail.setEnemies(enemies);

		return detail;
	}

}

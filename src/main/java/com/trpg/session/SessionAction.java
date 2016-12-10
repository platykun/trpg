package com.trpg.session;

import com.trpg.entity.CharacterInfo;
import com.trpg.entity.RelatedCharacterRepository;
import com.trpg.entity.Scenario;
import com.trpg.entity.ScenarioRepository;
import com.trpg.scenario.ScenarioDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class SessionAction {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	private static final RowMapper<SessionOutline> sessionInfoRowMapper = (rs, i) -> {
		SessionOutline sessionOutline =  new SessionOutline();
		sessionOutline.setId(rs.getInt("id"));
		sessionOutline.setScenarioId(rs.getInt("scenario_id"));
		sessionOutline.setStatus(rs.getInt("status"));
		return sessionOutline;
	};

	/**
	 * セッションの一覧を取得する。
	 * 
	 * @return シナリオ一覧
	 */
	List<SessionOutline> getSessionList() {
		String getSessionSQL = "SELECT * FROM SESSION_INFO";

		List<SessionOutline> result = jdbcTemplate.query(getSessionSQL, new MapSqlParameterSource(), sessionInfoRowMapper);

		return result;
	}

}

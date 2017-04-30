package com.trpg.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SessionAction {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final RowMapper<SessionOutline> sessionInfoRowMapper = (rs, i) -> {
		SessionOutline sessionOutline =  new SessionOutline();
		sessionOutline.setId(rs.getInt("id"));
		sessionOutline.setScenarioId(rs.getInt("scenario_id"));
		sessionOutline.setStatus(rs.getInt("status"));
		sessionOutline.setTitle(rs.getString("title"));
		return sessionOutline;
	};

	/**
	 * セッションの一覧を取得する。
	 * 
	 * @return シナリオ一覧
	 */
	public List<SessionOutline> getSessionList() {
		String getSessionSQL = "SELECT SF.ID ID, SF.SCENARIO_ID SCENARIO_ID, SF.STATUS STATUS, S.TITLE TITLE " +
				"FROM SESSION_INFO SF, SCENARIO S WHERE SF.SCENARIO_ID = S.ID";

		List<SessionOutline> result =
				jdbcTemplate.query(getSessionSQL, new MapSqlParameterSource(), sessionInfoRowMapper);

		return result;
	}

}

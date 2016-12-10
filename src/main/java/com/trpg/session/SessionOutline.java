package com.trpg.session;

import com.trpg.entity.Scenario;
import com.trpg.scenario.ScenarioCharacterForm;
import lombok.Data;

import java.util.List;

/**
 * シナリオの詳細を格納する。
 * 
 * @author platykun
 *
 */
@Data
public class SessionOutline {
	/** セッションID */
	int id;

	/** シナリオID */
	int scenarioId;

	/** */
	int status;
}

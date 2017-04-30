package com.trpg.scenario;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * シナリオ一覧画面に表示するためのシナリオ概要を格納する。
 * 
 * @author Platykun
 *
 */
@Data
@AllArgsConstructor
public class ScenarioOutlineForm {
	/** id */
	private int id;

	/** シナリオタイトル */
	private String title;

	/** シナリオ概要 */
	private String outline;
}

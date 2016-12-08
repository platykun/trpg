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
	private int id;
	private String title;
	private String outline;
}

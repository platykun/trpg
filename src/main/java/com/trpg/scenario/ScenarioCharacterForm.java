package com.trpg.scenario;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * シナリオ一覧画面に表示するためのキャラクター情報を格納する。
 * 
 * @author platykun
 *
 */
@Data
@AllArgsConstructor
public class ScenarioCharacterForm {
	private int id;
	private String name;
	private int sanityPoint;
}

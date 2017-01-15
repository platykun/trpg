package com.trpg.scenario;

import java.util.List;

import com.trpg.entity.CharacterInfo;
import com.trpg.entity.Scenario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * シナリオの詳細を格納する。
 * 
 * @author platykun
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScenarioDetail {
	/** シナリオID */
	private int id;
	/** タイトル */
	private String title;
	/** 概要 */
	private String outline;

	/** 推奨人数　*/
	private String recommendPlayer;

	/** 推定プレイ時間 */
	private String time;

	/** 内容 */
	private String text;
	
	/** NPCのリスト */
	private List<CharacterInfo> npcs;
	
	/** 敵のリスト */
	private List<CharacterInfo> enemies;

	/** アイテムのリスト */
	private List<ItemForm> items;

	/** シーンのリスト */
	private List<SceneForm> scenes;

	public ScenarioDetail(Scenario scenario){
		this.title=scenario.getTitle();
		this.outline = scenario.getOutline();
		this.recommendPlayer = scenario.getRecommendPlayer();
		this.time = scenario.getTime();
		this.text = scenario.getText();
	}

}

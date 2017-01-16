package com.trpg.scenario;

import java.util.List;
import java.util.stream.Collectors;

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

	/** 推奨人数 */
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

	/** 導入シーンのリスト */
	private List<SceneForm> introductionScenes;

	/** イベントシーンのリスト */
	private List<SceneForm> eventScenes;

	/** 場所シーンのリスト */
	private List<SceneForm> placeScenes;

	/** 時間シーンのリスト */
	private List<SceneForm> timeScenes;

	/** 戦闘シーンのリスト */
	private List<SceneForm> combatScenes;

	/** 結末シーンのリスト */
	private List<SceneForm> endingScenes;
	
	/** シーンの全量リスト */
	private List<SceneForm> allScenes;

	public ScenarioDetail(Scenario scenario) {
		this.title = scenario.getTitle();
		this.outline = scenario.getOutline();
		this.recommendPlayer = scenario.getRecommendPlayer();
		this.time = scenario.getTime();
		this.text = scenario.getText();
	}

	/**
	 * シーンを取得して、各シーンへ格納する。
	 */
	public void setScenes(List<SceneForm> scenes) {
		//TODO: 表示する用にシーンごとにリストを切り分けしているが、idとtitleのみ格納できさえすれば良い
		this.introductionScenes = scenes.stream().filter(s -> s.getSceneGroup() == 10).collect(Collectors.toList());
		this.eventScenes = scenes.stream().filter(s -> s.getSceneGroup() == 20).collect(Collectors.toList());
		this.placeScenes = scenes.stream().filter(s -> s.getSceneGroup() == 30).collect(Collectors.toList());
		this.timeScenes = scenes.stream().filter(s -> s.getSceneGroup() == 40).collect(Collectors.toList());
		this.combatScenes = scenes.stream().filter(s -> s.getSceneGroup() == 50).collect(Collectors.toList());
		this.endingScenes = scenes.stream().filter(s -> s.getSceneGroup() == 50).collect(Collectors.toList());
		this.allScenes = scenes;
	}

}

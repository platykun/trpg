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
		// TODO: 表示する用にシーンごとにリストを切り分けしているが、idとtitleのみ格納できさえすれば良い
		this.introductionScenes = scenes.stream().filter(s -> s.getSceneGroup() == 10).collect(Collectors.toList());
		this.eventScenes = scenes.stream().filter(s -> s.getSceneGroup() == 20).collect(Collectors.toList());
		this.placeScenes = scenes.stream().filter(s -> s.getSceneGroup() == 30).collect(Collectors.toList());
		this.timeScenes = scenes.stream().filter(s -> s.getSceneGroup() == 40).collect(Collectors.toList());
		this.combatScenes = scenes.stream().filter(s -> s.getSceneGroup() == 50).collect(Collectors.toList());
		this.endingScenes = scenes.stream().filter(s -> s.getSceneGroup() == 60).collect(Collectors.toList());
		this.allScenes = scenes;
	}

	/**
	 * キャラクターのIDを取得し、シナリオ内の敵、NPCのうち合致するキャラクターがいればその名前を返却する。<br>
	 * 存在しない場合は空文字を返却
	 * 
	 * @param id キャラクターID
	 * @return 名前
	 */
	public String getCharacterNameFromId(int id) {
		List<CharacterInfo> npcList = this.npcs.stream().filter(s -> s.getId() == id).collect(Collectors.toList());
		if (npcList.size() > 0) {
			return npcList.get(0).getName();
		}
		List<CharacterInfo> enemyList = this.enemies.stream().filter(s -> s.getId() == id).collect(Collectors.toList());
		if (enemyList.size() > 0) {
			return enemyList.get(0).getName();
		}
		return "";
	}

	/**
	 * シーンのIDを取得し、合致するIDがあればそのタイトルを返却する。<br>
	 * 存在しない場合は空文字を返却。
	 * 
	 * @param id シーンID
	 * @return タイトル
	 */
	public String getSceneTitleFromId(int id) {
		List<SceneForm> sceneList = this.allScenes.stream().filter(a -> a.getId() == id).collect(Collectors.toList());
		if (sceneList.size() > 0) {
			return sceneList.get(0).getTitle();
		}
		return "";
	}

	// TODO: シーン切り替えのタブも同様のgetterを使って実装する。
	public List<SceneForm> getSceneFromSceneGroup(int id) {
		return this.allScenes.stream().filter(a -> a.getSceneGroup() == id).collect(Collectors.toList());
	}

}

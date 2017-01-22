package com.trpg.scenario;

import java.util.List;
import java.util.stream.Collectors;

import com.trpg.entity.CharacterInfo;
import com.trpg.entity.Scenario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * シナリオの作成画面のformクラス。
 * 
 * @author platykun
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScenarioCreateForm {
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

	/** シーンの全量リスト */
	private List<SceneForm> scenes;

	public ScenarioCreateForm(Scenario scenario) {
		this.title = scenario.getTitle();
		this.outline = scenario.getOutline();
		this.recommendPlayer = scenario.getRecommendPlayer();
		this.time = scenario.getTime();
		this.text = scenario.getText();
	}
	
	public void addItem(String name, String imgUrl, String text){
		ItemForm newItem = new ItemForm();
		newItem.setSerialNum(this.items.size() + 1);
		newItem.setName(name);
		newItem.setImgUrl(imgUrl);
		newItem.setText(text);
		items.add(newItem);
	}
}
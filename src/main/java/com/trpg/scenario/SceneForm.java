package com.trpg.scenario;

import java.util.Collections;
import java.util.List;

import com.trpg.entity.Scene;
import lombok.Data;

/**
 * シナリオの詳細を格納する。
 * 
 * @author platykun
 *
 */
@Data
public class SceneForm {
	/** シーンID */
	private int id;
	/** シナリオID */
	private int scenarioId;
	/** 連番 */
	private int serialNum;
	/** 種別 */
	private int sceneGroup;
	/** タイトル */
	private String title;
	/** 概要 */
	private String outline;
	/** 内容 */
	private String text;
	/** 登場キャラクターIDリスト */
	private List<Integer> appearCharacters;
	/** 登場キャラクター名リスト */
	private List<String> appearCharacterNames;
	/** シーンリンクIDリスト */
	private List<Integer> sceneLinkIds;
	/** シーンリンク名リスト */
	private List<String> sceneLinkNames;


	public Scene convertScene(){

		//TODO: 本来精査処理として行うべきだが、精査処理を実装していないためここで処理を行う。
		//あとで処理を行う場所を移動させる。
		//Listのうち、nullが格納された場合に除外させる。
		appearCharacters.removeAll(Collections.singleton(null));
	    appearCharacters.removeAll(Collections.singleton(0));
		sceneLinkIds.removeAll(Collections.singleton(null));
		sceneLinkIds.removeAll(Collections.singleton(0));

		Scene scene = new Scene();
		scene.setId(id);
		scene.setScenarioId(scenarioId);
		scene.setSerialNum(serialNum);
		scene.setSceneGroup(sceneGroup);
		scene.setTitle(title);
		scene.setOutline(outline);
		scene.setText(text);

		if(appearCharacters != null){
			switch(appearCharacters.size()){
				case 5 : scene.setAppearCharacter5(appearCharacters.get(4));
				case 4 : scene.setAppearCharacter4(appearCharacters.get(3));
				case 3 : scene.setAppearCharacter3(appearCharacters.get(2));
				case 2 : scene.setAppearCharacter2(appearCharacters.get(1));
				case 1 : scene.setAppearCharacter1(appearCharacters.get(0));
				default : break;
			}
		}
		if(sceneLinkIds != null){
			switch(sceneLinkIds.size()){
				case 5 : scene.setSceneLinkId5(sceneLinkIds.get(4));
				case 4 : scene.setSceneLinkId4(sceneLinkIds.get(3));
				case 3 : scene.setSceneLinkId3(sceneLinkIds.get(2));
				case 2 : scene.setSceneLinkId2(sceneLinkIds.get(1));
				case 1 : scene.setSceneLinkId1(sceneLinkIds.get(0));
				default : break;
			}
		}
		return scene;
	}
}

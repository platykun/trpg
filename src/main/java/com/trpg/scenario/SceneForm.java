package com.trpg.scenario;

import java.util.List;

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
}

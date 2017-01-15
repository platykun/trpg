package com.trpg.scenario;

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
	/** 登場キャラクターID1 */
	private int appearCharacter1;
	/** 登場キャラクターID2 */
	private int appearCharacter2;
	/** 登場キャラクターID3 */
	private int appearCharacter3;
	/** 登場キャラクターID4 */
	private int appearCharacter4;
	/** 登場キャラクターID5 */
	private int appearCharacter5;
	/** シーンリンクID1 */
	private int sceneLinkId1;
	/** シーンリンクID2 */
	private int sceneLinkId2;
	/** シーンリンクID3 */
	private int sceneLinkId3;
	/** シーンリンクID4 */
	private int sceneLinkId4;
	/** シーンリンクID5 */
	private int sceneLinkId5;
}

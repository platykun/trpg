package com.trpg.scenario;

import lombok.Data;

/**
 * アイテムの詳細を格納する。
 * 
 * @author platykun
 *
 */
@Data
public class ItemForm {
	/** アイテムID */
	private int id;
	/** シナリオID */
	private int scenarioId;
	/** シーンID */
	private int sceneId;
	/** 連番 */
	private int serialNum;
	/** 名前 */
	private String name;
	/** 画像URL */
	private String imgUrl;
	/** 内容 */
	private String text;
}

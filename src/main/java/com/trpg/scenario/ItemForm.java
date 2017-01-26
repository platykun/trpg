package com.trpg.scenario;

import java.util.List;

import com.trpg.entity.CharacterInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * アイテムの詳細を格納する。
 * 
 * @author platykun
 *
 */
@NoArgsConstructor
@AllArgsConstructor
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

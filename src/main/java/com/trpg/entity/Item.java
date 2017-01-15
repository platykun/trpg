package com.trpg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	/** ID */
	@Id
	@GeneratedValue
	private int id;
	/** シナリオID */
	private int scenarioId;
	/** シーンID */
	private int sceneId;
	/** 連番 */
	private int serialNum;
	/** 画像URL */
	private String imgUrl;
	/** 内容 */
	private String text;
}

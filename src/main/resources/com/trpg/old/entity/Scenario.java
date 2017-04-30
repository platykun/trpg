package com.trpg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "scenario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scenario {
	@Id
	@GeneratedValue
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
	
}

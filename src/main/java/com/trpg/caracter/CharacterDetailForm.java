package com.trpg.caracter;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * キャラクター一覧画面に表示するためのキャラクター概要を格納する。
 * 
 * @author platykun
 *
 */
@Data
@AllArgsConstructor
public class CharacterDetailForm {
	/**
	 * 引数がない場合はデフォルト値を設定する。
	 */
	public CharacterDetailForm() {
	}
	/** キャラクターID */
	private int id;

	////基礎プロフィール////
	/** 名前 */
	private String name;
	
	/** 学校・学位 */
	private String school;
	
	/** 出身 */
	private String comeFrom;
	
	/** 精神的な障害 */
	private String mentalDisorder;
	
	/** 性別 */
	private String sex;
	
	/** 年齢 */
	private int age;
	
	////能力値////
	/** 筋力 */
	private int str;
	/** 知性 ※intがjavaの予約語のためintelligenceとして実装　*/
	private int intelligence;
	/** 外見 */
	private int app;
	/** 体格 */
	private int siz;
	/** 敏捷性 */
	private int dex;
	/** 体力 */
	private int con;
	/** 精神力 */
	private int pow;
	/** 教養 */
	private int edu;

	////ポイント////
	/** 正気度ポイント */
	private int sanityPoint;
	/** マジック・ポイント */
	private int magicPoint;
	/** 耐久力 */
	private int durability;
}

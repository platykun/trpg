package com.trpg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="character_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterInfo {
	/** キャラクターID */
	@Id
	private int characterId;

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
	
	////技能////
	/** 言いくるめ */
	/** 医学 */
	/** 運転（自動車） */
	/** 応急手当 */
	/** オカルト */
	/** 回避 */
	/** 化学 */
	/** 鍵開け */
	/** 隠す */
	/** 隠れる */
	/** 機械修理 */
	/** 聞き耳 */
	/** クトゥルフ神話 */
	/** 芸術 */
	/** 経理 */
	/** 考古学 */
	/** コンピューター */
	/** 忍び歩き */
	/** 写真術 */
	/** 重機械操作 */
	/** 乗馬 */
	/** 信用 */
	/** 心理学 */
	/** 人類学 */
	/** 水泳 */
	/** 制作1 */
	/** 制作2 */
	/** 制作3 */
	/** 精神分析 */
	/** 生物学 */
	/** 説得 */
	/** 操縦1 */
	/** 操縦2 */
	/** 操縦3 */
	/** 地質学 */
	/** 跳躍 */
	/** 追跡 */
	/** 電気修理 */
	/** 電子工学 */
	/** 天文学 */
	/** 投擲 */
	/** 登攀 */
	/** 図書館 */
	/** ナビゲート */
	/** 値切り */
	/** 博物学 */
	/** 物理学 */
	/** 変装 */
	/** 法律 */
	/** 他の言語1 */
	/** 他の言語2 */
	/** 母国語（EDU×２） */
	/** マーシャルアーツ */
	/** 目星 */
	/** 薬学 */
	/** 歴史1 */
	/** 歴史2 */
	/** サブマシンガン */
	/** ショットガン */
	/** マシンガン */
	/** ライフル */
	/** キック */
	/** 組み付き */
	/** こぶし */
	/** 頭突き */
	/** 近接戦1 */
	/** 近接戦2 */
	/** 火器1 */
	/** 火器2 */
	/** 火器3 */
	/** 火器4 */
	/** 火器5 */
	/** 火器6　*/
	
	/** 裏面の情報も記載する */
}

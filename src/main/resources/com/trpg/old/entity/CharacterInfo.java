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
	@GeneratedValue
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
	
	////技能////
	/** 言いくるめ */
	private int dictionary;
	/** 医学 */
	private int medicine;
	/** 運転（自動車） */
	private int driveCarriage;
	/** 応急手当 */
	private int firstAid;
	/** オカルト */
	private int occult;
	/**  回避 */
	private int dodge;
	/** 化学 */
	private int chemistry;
	/** 鍵開け */
	private int locksmith;
	/** 隠す */
	private int conceal;
	/** 隠れる */
	private int hide;
	/** 機械修理 */
	private int mechanicalRepair;
	/** 聞き耳 */
	private int listen;
	/** クトゥルフ神話 */
	private int cthulhuMythos;
	/** 芸術 */
	private int art;
	/** 経理 */
	private int accounting;
	/** 考古学 */
	private int archaeology;
	/** コンピューター */
	private int computer;
	/** 忍び歩き */
	private int sneak;
	/** 写真術 */
	private int photography;
	/** 重機械操作 */
	private int operateHvyMachine;
	/** 乗馬 */
	private int ride;
	/** 信用 */
	private int creditRating;
	/** 心理学 */
	private int psychology;
	/** 人類学 */
	private int anthropology;
	/** 水泳 */
	private int swim;
	/** 制作1 */
	private int production1;
	/** 制作2 */
	private int production2;
	/** 制作3 */
	private int production3;
	/** 精神分析 */
	private int psychoanalysis;
	/** 生物学 */
	private int biology;
	/** 説得 */
	private int persuade;
	/** 操縦1 */
	private int pilot1;
	/** 操縦2 */
	private int pilot2;
	/** 操縦3 */
	private int pilot3;
	/** 地質学 */
	private int geology;
	/** 跳躍 */
	private int jump;
	/** 追跡 */
	private int pursuit;
	/** 電気修理 */
	private int electricalRepair;
	/** 電子工学 */
	private int electronics;
	/** 天文学 */
	private int astronomy;
	/** 投擲 */
	private int throwSomething;
	/** 登攀 */
	private int climb;
	/** 図書館 */
	private int library;
	/** ナビゲート */
	private int navigate;
	/** 値切り */
	private int priceCut;
	/** 博物学 */
	private int naturalHistory;
	/** 物理学 */
	private int physics;
	/** 変装 */
	private int disguise;
	/** 法律 */
	private int law;
	/** 他の言語1 */
	private int otherLanguage1;
	/** 他の言語2 */
	private int otherLanguage2;
	/** 母国語（EDU×２） */
	private int ownLanguage;
	/** マーシャルアーツ */
	private int martial;
	/** 目星 */
	private int spotHidden;
	/** 薬学 */
	private int pharmacy;
	/** 歴史1 */
	private int history1;
	/** 歴史2 */
	private int history2;
	/** 拳銃 */
	private int gun;
	/** サブマシンガン */
	private int subMachineGun;
	/** ショットガン */
	private int shotgun;
	/** マシンガン */
	private int machineGun;
	/** ライフル */
	private int rifle;
	/** キック */
	private int kick;
	/** 組み付き */
	private int assembly;
	/** こぶし */
	private int first;
	/** 頭突き */
	private int headButt;
	/** 近接戦1 */
	private int handWeapon1;
	/** 近接戦2 */
	private int handWeapon2;
	/** 火器1 */
	private int firearm1;
	/** 火器2 */
	private int firearm2;
	/** 火器3 */
	private int firearm3;
	/** 火器4 */
	private int firearm4;
	/** 火器5 */
	private int firearm5;
	/** 火器6 */
	private int firearm6;
	
	/** 裏面の情報も記載する */
}

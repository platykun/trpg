package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * 技能種別
 * 
 * @author Platykun
 *
 */
public enum InvestigatorSkillType {

    DICTIONARY(0, "言いくるめ", 0),
    MEDICINE(1, "医学", 0),
    DRIVE_CARRIAGE(2, "運転（自動車）", 0),
    FIRST_AID(3, "応急手当", 0),
    OCCULT(4, "オカルト", 0),
    DODGE(5, "回避", 0),
    CHEMISTRY(6, "化学", 0),
    LOCKSMITH(7, "鍵開け", 0),
    CONCEAL(8, "隠す", 0),
    HIDE(9, "隠れる", 0),
    MECHANICAL_REPAIR(10, "機械修理", 0),
    LISTEN(11, "聞き耳", 0),
    CTHULHU_MYTHOS(12, "クトゥルフ神話", 0),
    ART(13, "芸術", 0),
    ACCOUNTING(14, "経理", 0),
    ARCHAEOLOGY(15, "考古学", 0),
    COMPUTER(16, "コンピューター", 0),
    SNEAK(17, "忍び歩き", 0),
    PHOTOGRAPHY(18, "写真術", 0),
    OPERATEHVY_MACHINE(19, "重機械操作", 0),
    RIDE(20, "乗馬", 0),
    CREDIT_RATING(21, "信用", 0),
    PSYCHOLOGY(22, "心理学", 0),
    ANTHROPOLOGY(23, "人類学", 0),
    SWIM(24, "水泳", 0),
    PRODUCTION1(25, "制作1", 0),
    PRODUCTION2(26, "制作2", 0),
    PRODUCTION3(27, "制作3", 0),
    PSYCHOANALYSIS(28, "精神分析", 0),
    BIOLOGY(29, "生物学", 0),
    PERSUADE(30, "説得", 0),
    PILOT1(31, "操縦1", 0),
    PILOT2(32, "操縦2", 0),
    PILOT3(33, "操縦3", 0),
    GEOLOGY(34, "地質学", 0),
    JUMP(35, "跳躍", 0),
    PURSUIT(36, "追跡", 0),
    ELECTRICAL_REPAIR(37, "電気修理", 0),
    ELECTRONICS(38, "電子工学", 0),
    ASTRONOMY(39, "天文学", 0),
    THROW_SOMETHING(40, "投擲", 0),
    CLIMB(41, "登攀", 0),
    LIBRARY(42, "図書館", 0),
    NAVIGATE(43, "ナビゲート", 0),
    PRICE_CUT(44, "値切り", 0),
    NATURAL_HISTORY(45, "博物学", 0),
    DISGUISE(47, "変装", 0),
    LAW(48, "法律", 0),
    OTHER_LANGUAGE1(49, "他の言語1", 0),
    OTHER_LANGUAGE2(50, "他の言語2", 0),
    OWN_LANGUAGE(51, "母国語", 0),
    MARTIAL(52, "マーシャルアーツ", 0),
    SPOT_HIDDEN(53, "目星", 0),
    PHARMACY(54, "薬学", 0),
    HISTORY1(55, "歴史1", 0),
    HISTORY2(56, "歴史2", 0);
    //武器系は技能対象外
// GUN(), // 拳銃
// SUBMACHINEGUN(), // サブマシンガン
// SHOTGUN(), // ショットガン
// MACHINEGUN(), // マシンガン
// RIFLE(), // ライフル
// KICK(), // キック
// ASSEMBLY(), // 組み付き
// FIRST(), // こぶし
// HEADBUTT(), // 頭突き
// HANDWEAPON1(), // 近接戦1
// HANDWEAPON2(), // 近接戦2
// FIREARM1(), // 火器1
// FIREARM2(), // 火器2
// FIREARM3(), // 火器3
// FIREARM4(), // 火器4
// FIREARM5(), // 火器5
// FIREARM6(), // 火器6

    @Getter
    private final int id;
    @Getter
    private final String name;
    @Getter
    private final int initValue;

    private InvestigatorSkillType(final int id, final String name, final int initValue){
        this.id = id;
        this.name = name;
        this.initValue = initValue;
    }

    public static InvestigatorSkillType getType(final int id){
        InvestigatorSkillType[] types = InvestigatorSkillType.values();
        for(InvestigatorSkillType type : types){
            if(type.getId() ==  id){
                return type;
            }
        }
        return null;
    }
}

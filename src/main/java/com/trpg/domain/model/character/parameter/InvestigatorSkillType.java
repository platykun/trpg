package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * 技能種別
 * 
 * @author Platykun
 *
 */
public enum InvestigatorSkillType {

    DICTIONARY(0, "言いくるめ", 5),
    MEDICINE(1, "医学", 5),
    DRIVE_CARRIAGE(2, "運転（自動車）", 20),
    FIRST_AID(3, "応急手当", 30),
    OCCULT(4, "オカルト", 5),
    DODGE(5, "回避", 0),
    CHEMISTRY(6, "化学", 1),
    LOCKSMITH(7, "鍵開け", 1),
    CONCEAL(8, "隠す", 15),
    HIDE(9, "隠れる", 10),
    MECHANICAL_REPAIR(10, "機械修理", 20),
    LISTEN(11, "聞き耳", 25),
    CTHULHU_MYTHOS(12, "クトゥルフ神話", 0),
    ART(13, "芸術", 5),
    ACCOUNTING(14, "経理", 10),
    ARCHAEOLOGY(15, "考古学", 1),
    COMPUTER(16, "コンピューター", 1),
    SNEAK(17, "忍び歩き", 10),
    PHOTOGRAPHY(18, "写真術", 10),
    OPERATEHVY_MACHINE(19, "重機械操作", 1),
    RIDE(20, "乗馬", 5),
    CREDIT_RATING(21, "信用", 15),
    PSYCHOLOGY(22, "心理学", 5),
    ANTHROPOLOGY(23, "人類学", 1),
    SWIM(24, "水泳", 25),
    PRODUCTION1(25, "制作1", 5),
    PRODUCTION2(26, "制作2", 5),
    PRODUCTION3(27, "制作3", 5),
    PSYCHOANALYSIS(28, "精神分析", 1),
    BIOLOGY(29, "生物学", 1),
    PERSUADE(30, "説得", 15),
    PILOT1(31, "操縦1", 1),
    PILOT2(32, "操縦2", 1),
    PILOT3(33, "操縦3", 1),
    GEOLOGY(34, "地質学", 1),
    JUMP(35, "跳躍", 25),
    PURSUIT(36, "追跡", 10),
    ELECTRICAL_REPAIR(37, "電気修理", 10),
    ELECTRONICS(38, "電子工学", 1),
    ASTRONOMY(39, "天文学", 1),
    THROW_SOMETHING(40, "投擲", 25),
    CLIMB(41, "登攀", 40),
    LIBRARY(42, "図書館", 25),
    NAVIGATE(43, "ナビゲート", 10),
    PRICE_CUT(44, "値切り", 5),
    NATURAL_HISTORY(45, "博物学", 10),
    DISGUISE(47, "変装", 1),
    LAW(48, "法律", 5),
    OTHER_LANGUAGE1(49, "他の言語1", 1),
    OTHER_LANGUAGE2(50, "他の言語2", 1),
    OWN_LANGUAGE(51, "母国語", 0),
    MARTIAL(52, "マーシャルアーツ", 1),
    SPOT_HIDDEN(53, "目星", 25),
    PHARMACY(54, "薬学", 1),
    HISTORY1(55, "歴史1", 20),
    HISTORY2(56, "歴史2", 20);
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

    InvestigatorSkillType(final int id, final String name, final int initValue){
        this.id = id;
        this.name = name;
        this.initValue = initValue;
    }

    /**
     * 技能種別を取得する。
     *
     * @param id 技能ID
     * @return 技能種別
     */
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

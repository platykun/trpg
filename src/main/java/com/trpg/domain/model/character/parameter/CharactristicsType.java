package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * 能力値パラメータ種別
 * 
 * @author Platykun
 *
 */
public enum CharactristicsType {

    STR(0, "筋力", 0),
    INTELLIGENCE(1, "知性", 0),
    APP(2, "外見", 0),
    SIZ(3, "体格", 0),
    DEX(4, "敏捷性", 0),
    CON(5, "体力", 0),
    POW(6, "精神力", 0),
    EDU(7, "教養", 0);

    /** パラメータ種別ID */
    @Getter
    private final int id;
    /** パラメータ名 */
    @Getter
    private final String name;
    @Getter
    private final int initValue;

    CharactristicsType(final int id, final String name, final int initValue){
        this.id = id;
        this.name = name;
        this.initValue = initValue;
    }

    /**
     * 引数のIDに合致したパラメータ種別オブジェクトを返却する。<br>
     * IDが存在：種別を返却。<br>
     * IDが存在しない：nullを返却。
     *
     * @param id 能力値パラメータ種別ID
     * @return 能力値パラメータ種別
     */
    public static CharactristicsType getType(final int id){
        CharactristicsType[] types = CharactristicsType.values();
        for(CharactristicsType type : types){
            if(type.getId() == id){
                return type;
            }
        }
        return null;
    }
}

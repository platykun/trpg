package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * パラメータ種別
 * 
 * @author Platykun
 *
 */
public enum ParameterType {
    CHARACTERISTICS(0,"能力値", 0),
    SANITY_POINTS(1,"正気度", 0),
    MAGIC_POINTS(2,"マジックポイント", 0),
    HIT_POINTS(3,"耐久力", 0),
    INVESTIGATOR_SKILLS(4,"技能", 0),
    WEAPONS(5,"武器", 0);
    @Getter
    private final int id;
    @Getter
    private final String name;
    @Getter
    private final int initValue;

    ParameterType(final int id, final String name, final int initValue){
        this.id = id;
        this.name = name;
        this.initValue = initValue;
    }

    /**
     * 引数のIDに合致したパラメータ種別オブジェクトを返却する。<br>
     * IDが存在：種別を返却。<br>
     * IDが存在しない：nullを返却。
     *
     * @param id パラメータ種別ID
     * @return パラメータ種別
     */
    public static ParameterType getType(final int id){
        ParameterType[] types = ParameterType.values();
        for(ParameterType type : types){
            if(type.getId() ==  id){
                return type;
            }
        }
        return null;
    }
}

package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * パラメータ種別
 * 
 * @author Platykun
 *
 */
public enum ParameterType {
    CHARACTERISTICS(0), //能力値
    SANITY_POINTS(1), //正気度
    MAGIC_POINTS(2),  //マジックポイント
    HIT_POINTS(3), //耐久力
    INVESTIGATOR_SKILLS(4), //技能
    WEAPONS(5); //武器
    @Getter
    private final int id;
    
    private ParameterType(final int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }

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
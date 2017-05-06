package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * パラメータ種別
 * 
 * @author Platykun
 *
 */
public enum CharactristicsType {

    STR(0), // 筋力
    INTELLIGENCE(1), // 知性
    APP(2), // 外見
    SIZ(3), // 体格
    DEX(4), // 敏捷性
    CON(5), // 体力
    POW(6), // 精神力
    EDU(7);// 教養

    @Getter
    private final int id;

    private CharactristicsType(final int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }

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

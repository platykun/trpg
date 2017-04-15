package com.trpg.domain.model.character.parameter;

/**
 * パラメータ種別
 * 
 * @author Platykun
 *
 */
public enum ParameterType {
    CARACTERISTICS(0), //能力値
    SANITY_POINTS(1), //正気度
    MAGIC_POINTS(2),  //マジックポイント
    HIT_POINTS(3), //耐久力
    INVESTICATOR_SKILLS(4), //技能
    WEAPONS(5); //武器
    
    private final int id;
    
    private ParameterType(final int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}

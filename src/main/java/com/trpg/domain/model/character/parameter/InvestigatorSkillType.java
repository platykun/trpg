package com.trpg.domain.model.character.parameter;

/**
 * 技能種別
 * 
 * @author Platykun
 *
 */
public enum InvestigatorSkillType {

    DICTIONARY(0), // 言いくるめ
    MEDICINE(1); // 医学


    private final int id;

    private InvestigatorSkillType(final int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}

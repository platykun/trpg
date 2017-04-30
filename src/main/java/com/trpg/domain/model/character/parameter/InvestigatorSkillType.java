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

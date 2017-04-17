package com.trpg.domain.model.character.parameter;

import java.util.Map;

/**
 *  技能パラメータ
 * 
 * @author Platykun
 *
 */
public class InvestigatorSkillParameter extends ParameterPattern {

    InvestigatorSkillType investigatorSkillType;

    InvestigatorSkillParameter(ParameterType type, int defaultValue, InvestigatorSkillType investigatorSkillType){
        super(type, defaultValue);
        this.investigatorSkillType = investigatorSkillType;
    }
    
    public Map<String, String> paramMap(){
        Map<String, String> map = super.paramMap();
        //TODO: 追加のパラメータを付与
        return map;
    }
}

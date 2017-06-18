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
}

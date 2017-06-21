package com.trpg.domain.model.character.parameter;

import java.util.Map;

/**
 *  技能パラメータ
 * 
 * @author Platykun
 *
 */
public class InvestigatorSkillParameter extends ParameterPattern {

    /** 技能種別 */
    InvestigatorSkillType investigatorSkillType;

    InvestigatorSkillParameter(ParameterType type, int defaultValue, InvestigatorSkillType investigatorSkillType){
        super(type, defaultValue);
        this.investigatorSkillType = investigatorSkillType;
    }

    /** 名前を取得する。 */
    @Override
    public String getName() {
        return investigatorSkillType.getName();
    }

    /** 初期値を取得する。 */
    @Override
    public int getInitValue(){
        return investigatorSkillType.getInitValue();
    }

}

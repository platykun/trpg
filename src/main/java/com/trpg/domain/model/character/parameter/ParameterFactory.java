package com.trpg.domain.model.character.parameter;

import com.trpg.domain.model.character.belonging.WeaponType;
import groovy.util.logging.Commons;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.trpg.domain.model.character.parameter.ParameterType.*;
import static com.trpg.domain.model.character.parameter.ParameterType.INVESTIGATOR_SKILLS;

/**
 * パラメータパターンオブジェクトを作成する
 * 
 * @author Platykun
 *
 */
@Component
public class ParameterFactory {

    private Parameter createDefaultParameter(int id, ParameterPattern parameterPattern, int param){
        Parameter defaultParameter = new Parameter(id, param, parameterPattern);
        return defaultParameter;
    }
    
    private Parameter createDiceValueParameter(int id, ParameterPattern parameterPattern, String diceValue){
        Parameter diceValueParameter = new Parameter(id, diceValue, parameterPattern);
        return diceValueParameter;
    }

    public Parameter createCharacteristics(int id, int param, int defaultValue, CharactristicsType charactristicsType){
        CharactristicsParameter charactristicsParameter = new CharactristicsParameter(CHARACTERISTICS, defaultValue, charactristicsType);
        Parameter parameter = createDefaultParameter(id, charactristicsParameter, param);
        return parameter;
    }

    public Parameter createSanityPoints(int id, int param, int defaultValue){
        SanityPointsParameter sanityPointsParameter = new SanityPointsParameter(SANITY_POINTS, defaultValue);
        Parameter parameter = createDefaultParameter(id, sanityPointsParameter, param);
        return parameter;
    }

    public Parameter createMagicPoints(int id, int param, int defaultValue){
        MagicPointsParameter magicPointsParameter = new MagicPointsParameter(MAGIC_POINTS, defaultValue);
        Parameter parameter = createDefaultParameter(id, magicPointsParameter, param);
        return parameter;
    }

    public Parameter createHitPoints(int id, int param, int defaultValue){
        HitPointsParameter hitPointsParameter= new HitPointsParameter(HIT_POINTS, defaultValue);
        Parameter parameter = createDefaultParameter(id, hitPointsParameter, param);
        return parameter;
    }
    public Parameter createInvestigatorSkill(int id, int param, int defaultValue, InvestigatorSkillType type){
        InvestigatorSkillParameter investigatorSkill= new InvestigatorSkillParameter(INVESTIGATOR_SKILLS, defaultValue, type);
        Parameter parameter = createDefaultParameter(id, investigatorSkill, param);
        return parameter;
    }
    public Parameter createWeapons(int id, int param, int defaultValue, WeaponType weaponType){
        WeaponParameter weaponParameter = new WeaponParameter(defaultValue, weaponType);
        Parameter parameter = createDefaultParameter(id, weaponParameter, param);
        return parameter;
    }
}

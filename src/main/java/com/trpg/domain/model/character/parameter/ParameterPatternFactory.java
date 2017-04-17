package com.trpg.domain.model.character.parameter;

import com.trpg.domain.model.character.belonging.Weapon;
import com.trpg.domain.model.character.belonging.WeaponFactory;

import java.util.Map;

import static com.trpg.domain.model.character.parameter.ParameterType.*;

/**
 * パラメータパターンオブジェクトを作成する
 * 
 * @author Platykun
 *
 */
public class ParameterPatternFactory {
    public ParameterPattern create(Map<String, String> paramMap){
        ParameterType type = ParameterType.valueOf(paramMap.get("parameterType"));
        ParameterPattern param = null;

        switch(type){
            case CHARACTERISTICS : param = createCharacteristics(paramMap);
            case SANITY_POINTS : param = createSanityPoints(paramMap);
            case MAGIC_POINTS : param = createMagicPoints(paramMap);
            case HIT_POINTS : param = createHitPoints(paramMap);
            case INVESTIGATOR_SKILLS : param = createInvestigatorSkill(paramMap);
            case WEAPONS : param = createWeapons(paramMap);
            default : param = null;
        }

        return param;
    }

    private CharactristicsParameter createCharacteristics(Map<String, String> paramMap){
        String defaultValue = paramMap.get("defaultValue");
        CharactristicsType type = CharactristicsType.valueOf(paramMap.get("charactristicsType"));

        CharactristicsParameter charactristicsParameter = new CharactristicsParameter(CHARACTERISTICS, Integer.parseInt(defaultValue), type);
        return charactristicsParameter;
    }

    private SanityPointsParameter createSanityPoints(Map<String, String> paramMap){
        String defaultValue = paramMap.get("defaultValue");

        SanityPointsParameter sanityPointsParameter = new SanityPointsParameter(SANITY_POINTS, Integer.parseInt(defaultValue));
        return sanityPointsParameter;
    }

    private MagicPointsParameter createMagicPoints(Map<String, String> paramMap){
        String defaultValue = paramMap.get("defaultValue");

        MagicPointsParameter magicPointsParameter = new MagicPointsParameter(MAGIC_POINTS, Integer.parseInt(defaultValue));
        return magicPointsParameter;
    }

    private HitPointsParameter createHitPoints(Map<String, String> paramMap){
        String defaultValue = paramMap.get("defaultValue");

        HitPointsParameter hitPointsParameter= new HitPointsParameter(HIT_POINTS, Integer.parseInt(defaultValue));
        return hitPointsParameter;
    }

    private InvestigatorSkillParameter createInvestigatorSkill(Map<String, String> paramMap){
        String defaultValue = paramMap.get("defaultValue");
        InvestigatorSkillType subType = InvestigatorSkillType.valueOf(paramMap.get("investigatorSkillType"));

        InvestigatorSkillParameter investigatorSkill= new InvestigatorSkillParameter(INVESTIGATOR_SKILLS, Integer.parseInt(defaultValue), subType);
        return investigatorSkill;
    }
    private WeaponParameter createWeapons(Map<String, String> paramMap){
        String defaultValue = paramMap.get("defaultValue");
        WeaponFactory factory = new WeaponFactory();
        Weapon weapon = factory.create(paramMap);

        WeaponParameter parameter = new WeaponParameter(WEAPONS, Integer.parseInt(defaultValue), weapon);

        return parameter;
    }
}

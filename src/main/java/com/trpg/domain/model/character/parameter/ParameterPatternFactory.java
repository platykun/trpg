package com.trpg.domain.model.character.parameter;

import com.trpg.domain.model.character.belonging.Weapon;
import com.trpg.domain.model.character.belonging.WeaponFactory;
import com.trpg.domain.model.character.belonging.WeaponType;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.trpg.domain.model.character.parameter.ParameterType.*;

/**
 * パラメータパターンオブジェクトを作成する
 * 
 * @author Platykun
 *
 */
@Component
public class ParameterPatternFactory {
    public CharactristicsParameter createCharacteristics(int defaultValue, CharactristicsType charactristicsType){
        CharactristicsParameter charactristicsParameter = new CharactristicsParameter(CHARACTERISTICS, defaultValue, charactristicsType);
        return charactristicsParameter;
    }

    public SanityPointsParameter createSanityPoints(int defaultValue){
        SanityPointsParameter sanityPointsParameter = new SanityPointsParameter(SANITY_POINTS, defaultValue);
        return sanityPointsParameter;
    }

    public MagicPointsParameter createMagicPoints(int defaultValue){
        MagicPointsParameter magicPointsParameter = new MagicPointsParameter(MAGIC_POINTS, defaultValue);
        return magicPointsParameter;
    }

    public HitPointsParameter createHitPoints(int defaultValue){
        HitPointsParameter hitPointsParameter= new HitPointsParameter(HIT_POINTS, defaultValue);
        return hitPointsParameter;
    }

    public InvestigatorSkillParameter createInvestigatorSkill(int defaultValue, InvestigatorSkillType type){
        InvestigatorSkillParameter investigatorSkill= new InvestigatorSkillParameter(INVESTIGATOR_SKILLS, defaultValue, type);
        return investigatorSkill;
    }
    
    public WeaponParameter createWeapons(int defaultValue, WeaponType weaponType){
        WeaponParameter parameter = new WeaponParameter(defaultValue, weaponType);
        return parameter;
    }
}

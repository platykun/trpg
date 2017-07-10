package com.trpg.mapper;

import com.trpg.domain.model.character.belonging.WeaponType;
import com.trpg.domain.model.character.parameter.*;
import com.trpg.entity.ParameterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Parameterテーブルのマッピングクラス
 */
@Controller
public class ParameterMapper {

    @Autowired
    ParameterFactory parameterFactory;

    public Parameter toDomain(ParameterEntity parameterEntity) {

        ParameterType parameterType = ParameterType.getType(parameterEntity.getParameterType());

        int id = parameterEntity.getId();
        int param = parameterEntity.getParameter();
        int defaultValue = parameterEntity.getDefaultValue();
        int subId = parameterEntity.getSubParameterType();

        Parameter parameter = null;

        switch(parameterType){
            case CHARACTERISTICS:
                CharactristicsType charactristicsType = CharactristicsType.getType(subId);
                parameter = parameterFactory.createCharacteristics(id, param, defaultValue, charactristicsType);
                break;
            case SANITY_POINTS:
                parameter = parameterFactory.createSanityPoints(id, param, defaultValue);
                break;
            case MAGIC_POINTS:
                parameter = parameterFactory.createMagicPoints(id, param, defaultValue);
                break;
            case HIT_POINTS:
                parameter = parameterFactory.createHitPoints(id, param, defaultValue);
                break;
            case INVESTIGATOR_SKILLS:
                InvestigatorSkillType investigatorSkillType = InvestigatorSkillType.getType(subId);
                parameter = parameterFactory.createInvestigatorSkill(id, param, defaultValue, investigatorSkillType);
                break;
            case WEAPONS:
                WeaponType weaponType = WeaponType.getType(subId);
                parameter = parameterFactory.createWeapon(id, param, defaultValue, weaponType);
                break;
        }

        return parameter;
    }

    public static ParameterEntity toEntity(int id, int characterId, Parameter parameter){

        ParameterEntity entity = new ParameterEntity(id, characterId,parameter.getParameter(), parameter.getDiceParameter() ,parameter.getParameterType().getId(), parameter.getDefaultValue(), parameter.getSubParameterTypeValue());
        return entity;
    }
}

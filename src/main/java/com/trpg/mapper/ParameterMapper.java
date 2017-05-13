package com.trpg.mapper;

import com.trpg.domain.model.character.character.Job;
import com.trpg.domain.model.character.parameter.DefaultParameter;
import com.trpg.domain.model.character.parameter.Parameter;
import com.trpg.domain.model.character.parameter.ParameterPattern;
import com.trpg.entity.JobDetailEntity;
import com.trpg.entity.JobEntity;
import com.trpg.entity.ParameterEntity;

import java.util.List;

/**
 * Parameterテーブルのマッピングクラス
 */

public class ParameterMapper {
    public static Parameter toDomain(ParameterEntity parameterEntity) {
        return null;
    }

    public static ParameterEntity toEntity(int id, int characterId, Parameter parameter){
        ParameterPattern parameterPattern = parameter.getParameterPattern();
        ParameterEntity entity = new ParameterEntity(id, characterId,parameter.getParameter(), parameter.getDiceParameter() ,parameterPattern.getParameterType().getId(), parameterPattern.getDefaultValue(), parameterPattern.getSubParameterTypeValue());
        return entity;
    }
}

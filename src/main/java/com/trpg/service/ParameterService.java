package com.trpg.service;

import com.trpg.domain.model.character.parameter.*;
import com.trpg.domain.repository.character.*;
import com.trpg.entity.*;
import com.trpg.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ParameterService {

    @Autowired
    ParameterFactory parameterfactory;

    @Autowired
    ParameterRepository parameterRepository;

    // 初期設定のパラメータリストを作成する。
    public ParameterList getInitialValueParameterList(){
        ParameterList parameterList = new ParameterList();

        Parameter sanityPointsParameter = parameterfactory.createSanityPoints(0, 0, 0);
        parameterList.add(sanityPointsParameter);

        Parameter magicPointsParameter = parameterfactory.createMagicPoints(0, 0, 0);
        parameterList.add(magicPointsParameter);

        Parameter hitPointsParameter = parameterfactory.createHitPoints(0, 0, 0);
        parameterList.add(hitPointsParameter);

        //STRなどのパラメータ設定
        Parameter strParam = parameterfactory.createCharacteristics(0, 0, 0, CharactristicsType.STR);
        parameterList.add(strParam);

        Parameter intParam = parameterfactory.createCharacteristics(0, 0, 0, CharactristicsType.INTELLIGENCE);
        parameterList.add(intParam);

        return parameterList;
    }

    public void insertParameter(ParameterList parameterList, int characterId){

        for(Parameter parameter : parameterList.getParameterList()){
            ParameterEntity parameterEntity = ParameterMapper.toEntity(parameter.getId(), characterId, parameter);
            parameterRepository.save(parameterEntity);
        }
    }

}

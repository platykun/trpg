package com.trpg.service;

import com.trpg.domain.model.character.parameter.*;
import com.trpg.domain.repository.character.*;
import com.trpg.entity.*;
import com.trpg.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * パラメータサービス。
 */
@Controller
public class ParameterService {
    /** パラメータファクトリ */
    @Autowired
    ParameterFactory parameterfactory;

    /** パラメータリストファクトリ */
    @Autowired
    ParameterListFactory parameterListFactory;

    /** パラメータリポジトリ */
    @Autowired
    ParameterRepository parameterRepository;

    /**
     * 初期値パラメータリストを作成する。
     * @return 初期値パラメータリスト。
     */
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

    /**
     * キャラクターIDをもとにパラメータを取得する。
     *
     * @param characterId キャラクタID
     * @return パラメータ
     */
    public ParameterList findByCharacterId(int characterId){
        List<ParameterEntity> parameterEntityList = parameterRepository.findByCharacterId(characterId);
        ParameterList parameterList = parameterListFactory.create();

        parameterEntityList.stream().forEach(p -> parameterList.add(ParameterMapper.toDomain(p)));

        return parameterList;
    }


}

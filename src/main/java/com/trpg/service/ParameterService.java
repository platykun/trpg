package com.trpg.service;

import com.trpg.domain.model.character.belonging.Belonging;
import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.character.Character;
import com.trpg.domain.model.character.character.*;
import com.trpg.domain.model.character.parameter.*;
import com.trpg.domain.repository.character.*;
import com.trpg.domain.repository.character.CharacterInfoRepository;
import com.trpg.entity.*;
import com.trpg.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ParameterService {

    @Autowired
    ParameterFactory parameterfactory;

    @Autowired
    ParameterPatternFactory parameterPatternFactory;

    // 初期設定のパラメータリストを作成する。
    public ParameterList getInitialValueParameterList(){
        ParameterList parameterList = new ParameterList();

        SanityPointsParameter sanityPointsParameter = parameterPatternFactory.createSanityPoints(0);
        parameterList.add(parameterfactory.createDefaultParameter(0, sanityPointsParameter, 0));

        MagicPointsParameter magicPointsParameter = parameterPatternFactory.createMagicPoints(0);
        parameterList.add(parameterfactory.createDefaultParameter(0, magicPointsParameter, 0));

        HitPointsParameter hitPointsParameter = parameterPatternFactory.createHitPoints(0);
        parameterList.add(parameterfactory.createDefaultParameter(0, hitPointsParameter, 0));

        //STRなどのパラメータ設定
        CharactristicsParameter strParam = parameterPatternFactory.createCharacteristics(0, CharactristicsType.STR);
        parameterList.add(parameterfactory.createDefaultParameter(0, strParam, 0));
        CharactristicsParameter intParam = parameterPatternFactory.createCharacteristics(0, CharactristicsType.INTELLIGENCE);
        parameterList.add(parameterfactory.createDefaultParameter(0, intParam, 0));


        return parameterList;
    }

}

package com.trpg.domain.model.character.parameter;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * パラメータオブジェクトのリストを作成する
 * 
 * @author Platykun
 *
 */
public class ParameterListFactory {

    @Autowired
    ParameterFactory parameterFactory;

    @Autowired
    ParameterPatternFactory parameterPatternFactory;



    //新規作成時初期値を設定する
    ParameterList createInitialParameter(){
        final int ID = 0;

        ParameterList parameterList = new ParameterList();

        SanityPointsParameter sanityPointsParameter = parameterPatternFactory.createSanityPoints(0);
        parameterList.add(parameterFactory.createDefaultParameter(ID, sanityPointsParameter, 0));

        MagicPointsParameter magicPointsParameter = parameterPatternFactory.createMagicPoints(0);
        parameterList.add(parameterFactory.createDefaultParameter(ID, magicPointsParameter, 0));

        HitPointsParameter hitPointsParameter = parameterPatternFactory.createHitPoints(0);
        parameterList.add(parameterFactory.createDefaultParameter(ID, hitPointsParameter, 0));


        //能力値パラメータ設定
        int strInitValue = CharactristicsType.STR.getInitValue();
        CharactristicsParameter strParam = parameterPatternFactory.createCharacteristics(strInitValue, CharactristicsType.STR);
        parameterList.add(parameterFactory.createDefaultParameter(ID, strParam, strInitValue));

        int intInitValue = CharactristicsType.INTELLIGENCE.getInitValue();
        CharactristicsParameter intParam = parameterPatternFactory.createCharacteristics(intInitValue, CharactristicsType.INTELLIGENCE);
        parameterList.add(parameterFactory.createDefaultParameter(ID, intParam, intInitValue));

        int appInitValue = CharactristicsType.APP.getInitValue();
        CharactristicsParameter appParam = parameterPatternFactory.createCharacteristics(appInitValue, CharactristicsType.APP);
        parameterList.add(parameterFactory.createDefaultParameter(ID, appParam, appInitValue));

        int sizInitValue = CharactristicsType.SIZ.getInitValue();
        CharactristicsParameter sizParam = parameterPatternFactory.createCharacteristics(sizInitValue, CharactristicsType.SIZ);
        parameterList.add(parameterFactory.createDefaultParameter(0, sizParam, sizInitValue));

        int dexInitValue = CharactristicsType.DEX.getInitValue();
        CharactristicsParameter dexParam = parameterPatternFactory.createCharacteristics(dexInitValue, CharactristicsType.DEX);
        parameterList.add(parameterFactory.createDefaultParameter(0, dexParam, dexInitValue));

        int conInitValue = CharactristicsType.CON.getInitValue();
        CharactristicsParameter conParam = parameterPatternFactory.createCharacteristics(conInitValue, CharactristicsType.CON);
        parameterList.add(parameterFactory.createDefaultParameter(0, conParam, conInitValue));

        int powInitValue = CharactristicsType.POW.getInitValue();
        CharactristicsParameter powParam = parameterPatternFactory.createCharacteristics(powInitValue, CharactristicsType.POW);
        parameterList.add(parameterFactory.createDefaultParameter(0, powParam, powInitValue));

        int eduInitValue = CharactristicsType.EDU.getInitValue();
        CharactristicsParameter eduParam = parameterPatternFactory.createCharacteristics(eduInitValue, CharactristicsType.EDU);
        parameterList.add(parameterFactory.createDefaultParameter(0, eduParam, eduInitValue));

        //技能種別設定
        for(InvestigatorSkillType skillType : InvestigatorSkillType.values()){
            int initValue = skillType.getInitValue();
            InvestigatorSkillParameter investigatorSkillParameter = parameterPatternFactory.createInvestigatorSkill(initValue, skillType);
            parameterList.add(parameterFactory.createDefaultParameter(ID, investigatorSkillParameter, initValue));
        }

        //武器技能設定
        parameterPatternFactory.createWeapons();


        return parameterList;
    }
}

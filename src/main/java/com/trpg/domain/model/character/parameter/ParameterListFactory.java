package com.trpg.domain.model.character.parameter;

import com.trpg.domain.model.character.belonging.WeaponType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * パラメータオブジェクトのリストを作成する
 * 
 * @author Platykun
 *
 */
@Component
public class ParameterListFactory {

    @Autowired
    private ParameterFactory parameterFactory;

    //新規作成時初期値を設定する
    public ParameterList createInitialParameter(){
        final int ID = 0;

        ParameterList parameterList = new ParameterList();

        Parameter sanityPointsParameter = parameterFactory.createSanityPoints(ID, 0, 0);
        parameterList.add(sanityPointsParameter);

        Parameter magicPointsParameter = parameterFactory.createMagicPoints(ID, 0, 0);
        parameterList.add(magicPointsParameter);

        Parameter hitPointsParameter = parameterFactory.createHitPoints(ID, 0, 0);
        parameterList.add(hitPointsParameter);


        //能力値パラメータ設定
        Parameter strParameter = parameterFactory.createCharacteristics(ID, 0, 0, CharactristicsType.STR);
        parameterList.add(strParameter);

        Parameter intParameter = parameterFactory.createCharacteristics(ID, 0, 0, CharactristicsType.INTELLIGENCE);
        parameterList.add(intParameter);

        Parameter appParameter = parameterFactory.createCharacteristics(ID, 0, 0, CharactristicsType.APP);
        parameterList.add(appParameter);

        Parameter sizParameter = parameterFactory.createCharacteristics(ID, 0, 0, CharactristicsType.SIZ);
        parameterList.add(sizParameter);

        Parameter dexParameter = parameterFactory.createCharacteristics(ID, 0, 0, CharactristicsType.DEX);
        parameterList.add(dexParameter);


        Parameter conParameter = parameterFactory.createCharacteristics(ID, 0, 0, CharactristicsType.CON);
        parameterList.add(conParameter);

        Parameter powParameter = parameterFactory.createCharacteristics(ID, 0, 0, CharactristicsType.POW);
        parameterList.add(powParameter);

        Parameter eduParameter = parameterFactory.createCharacteristics(ID, 0, 0, CharactristicsType.EDU);
        parameterList.add(eduParameter);

        //技能種別設定
        for(InvestigatorSkillType skillType : InvestigatorSkillType.values()){
            Parameter investigatorParameter = parameterFactory.createInvestigatorSkill(ID, 0, 0, skillType);
            parameterList.add(investigatorParameter);
        }

        //武器技能設定
        for(WeaponType weaponType : WeaponType.values()){
            Parameter weaponParameter = parameterFactory.createWeapons(ID, 0, 0, weaponType);
            parameterList.add(weaponParameter);
        }

        return parameterList;
    }
}

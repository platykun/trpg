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

    /** パラメータファクトリ */
    @Autowired
    private ParameterFactory parameterFactory;

    /**
     * 新規作成時初期値を設定する
     *
     * @return 新規作成時初期値パラメータリスト
     */
    public ParameterList createInitialParameter(){
        //登録用キャラクタなのでIDは0が採番される。
        final int ID;
        ID = 0;

        ParameterList parameterList = new ParameterList();

        Parameter sanityPointsParameter = parameterFactory.createInitSanityPoints(ID);
        parameterList.add(sanityPointsParameter);

        Parameter magicPointsParameter = parameterFactory.createInitMagicPoints(ID);
        parameterList.add(magicPointsParameter);

        Parameter hitPointsParameter = parameterFactory.createInitHitPoints(ID);
        parameterList.add(hitPointsParameter);


        //能力値パラメータ設定
        Parameter strParameter = parameterFactory.createInitCharacteristics(ID, CharactristicsType.STR);
        parameterList.add(strParameter);

        Parameter intParameter = parameterFactory.createInitCharacteristics(ID, CharactristicsType.INTELLIGENCE);
        parameterList.add(intParameter);

        Parameter appParameter = parameterFactory.createInitCharacteristics(ID, CharactristicsType.APP);
        parameterList.add(appParameter);

        Parameter sizParameter = parameterFactory.createInitCharacteristics(ID, CharactristicsType.SIZ);
        parameterList.add(sizParameter);

        Parameter dexParameter = parameterFactory.createInitCharacteristics(ID, CharactristicsType.DEX);
        parameterList.add(dexParameter);

        Parameter conParameter = parameterFactory.createInitCharacteristics(ID, CharactristicsType.CON);
        parameterList.add(conParameter);

        Parameter powParameter = parameterFactory.createInitCharacteristics(ID, CharactristicsType.POW);
        parameterList.add(powParameter);

        Parameter eduParameter = parameterFactory.createInitCharacteristics(ID, CharactristicsType.EDU);
        parameterList.add(eduParameter);

        //技能種別設定
        for(InvestigatorSkillType skillType : InvestigatorSkillType.values()){
            Parameter investigatorParameter = parameterFactory.createInitInvestigatorSkill(ID, skillType);
            parameterList.add(investigatorParameter);
        }

        //武器技能設定
        for(WeaponType weaponType : WeaponType.values()){
            Parameter weaponParameter = parameterFactory.createInitWeaponSkill(ID, weaponType);
            parameterList.add(weaponParameter);
        }

        return parameterList;
    }

    /**
     * 空のパラメータリストを作成する。
     *
     * @return パラメータリスト
     */
    public ParameterList create(){
        ParameterList parameterList = new ParameterList();
        return parameterList;
    }

}

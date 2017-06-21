package com.trpg.domain.model.character.parameter;

import com.trpg.domain.model.character.belonging.WeaponType;
import groovy.util.logging.Commons;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.trpg.domain.model.character.parameter.ParameterType.*;
import static com.trpg.domain.model.character.parameter.ParameterType.INVESTIGATOR_SKILLS;

/**
 * パラメータパターンオブジェクトを作成する
 * 
 * @author Platykun
 *
 */
@Component
public class ParameterFactory {

    /**
     * デフォルトのパラメータを作成する。
     *
     * @param id パラメータID
     * @param parameterPattern パラメータパターン
     * @param param パラメータ
     * @return パラメータオブジェクト
     */
    private Parameter createDefaultParameter(int id, ParameterPattern parameterPattern, int param){
        Parameter defaultParameter = new Parameter(id, param, parameterPattern);
        return defaultParameter;
    }

    /**
     * パラメータをダイスで決めるパラメータを作成する。
     *
     * @param id パラメータID
     * @param parameterPattern パラメータパターン
     * @param diceValue ダイス値
     * @return パラメータオブジェクト
     */
    private Parameter createDiceValueParameter(int id, ParameterPattern parameterPattern, String diceValue){
        Parameter diceValueParameter = new Parameter(id, diceValue, parameterPattern);
        return diceValueParameter;
    }

    /**
     * 能力値パラメータを作成する。
     *
     * @param id パラメータID
     * @param param パラメータ
     * @param defaultValue デフォルト値
     * @param charactristicsType 能力値パラメータ種別
     * @return 能力値パラメータオブジェクト
     */
    public Parameter createCharacteristics(int id, int param, int defaultValue, CharactristicsType charactristicsType){
        CharactristicsParameter charactristicsParameter = new CharactristicsParameter(CHARACTERISTICS, defaultValue, charactristicsType);
        Parameter parameter = createDefaultParameter(id, charactristicsParameter, param);
        return parameter;
    }

    /**
     * 正気度パラメータを作成する。
     *
     * @param id パラメータID
     * @param param パラメータ
     * @param defaultValue デフォルト値
     * @return 正気度パラメータオブジェクト
     */
    public Parameter createSanityPoints(int id, int param, int defaultValue){
        SanityPointsParameter sanityPointsParameter = new SanityPointsParameter(SANITY_POINTS, defaultValue);
        Parameter parameter = createDefaultParameter(id, sanityPointsParameter, param);
        return parameter;
    }

    /**
     * マジックポイントパラメータを作成する。
     *
     * @param id パラメータID
     * @param param パラメータ
     * @param defaultValue デフォルト値
     * @return マジックポイントパラメータオブジェクト
     */
    public Parameter createMagicPoints(int id, int param, int defaultValue){
        MagicPointsParameter magicPointsParameter = new MagicPointsParameter(MAGIC_POINTS, defaultValue);
        Parameter parameter = createDefaultParameter(id, magicPointsParameter, param);
        return parameter;
    }

    /**
     * 体力パラメータを作成する。
     *
     * @param id パラメータID
     * @param param パラメータ
     * @param defaultValue デフォルト値
     * @return 体力パラメータオブジェクト
     */
    public Parameter createHitPoints(int id, int param, int defaultValue){
        HitPointsParameter hitPointsParameter= new HitPointsParameter(HIT_POINTS, defaultValue);
        Parameter parameter = createDefaultParameter(id, hitPointsParameter, param);
        return parameter;
    }

    /**
     * 技能パラメータを作成する。
     *
     * @param id パラメータID
     * @param param パラメータ
     * @param defaultValue デフォルト値
     * @param type 技能種別
     * @return 技能パラメータオブジェクト
     */
    public Parameter createInvestigatorSkill(int id, int param, int defaultValue, InvestigatorSkillType type){
        InvestigatorSkillParameter investigatorSkill= new InvestigatorSkillParameter(INVESTIGATOR_SKILLS, defaultValue, type);
        Parameter parameter = createDefaultParameter(id, investigatorSkill, param);
        return parameter;
    }

    /**
     * 武器パラメータを作成する。
     *
     * @param id パラメータID
     * @param param パラメータ
     * @param defaultValue デフォルト値
     * @param weaponType 武器種別
     * @return 武器パラメータオブジェクト
     */
    public Parameter createWeapons(int id, int param, int defaultValue, WeaponType weaponType){
        WeaponParameter weaponParameter = new WeaponParameter(defaultValue, weaponType);
        Parameter parameter = createDefaultParameter(id, weaponParameter, param);
        return parameter;
    }
}

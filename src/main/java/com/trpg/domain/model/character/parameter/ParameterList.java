package com.trpg.domain.model.character.parameter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * パラメータ
 *
 * @author Platykun
 */
public class ParameterList {

    /** パラメータリスト */
    @Getter
    private ArrayList<Parameter> parameterList;

    public ParameterList(){
        parameterList = new ArrayList<Parameter>();
    }

    /**
     * パラメータリストにパラメータを追加する。
     *
     * @param parameter 追加するパラメータ
     */
    public void add(Parameter parameter){
        parameterList.add(parameter);
    }

    /**
     * 能力値のリストを返却する。
     *
     * @return 能力値パラメータリスト
     */
    public List<Parameter> getCharactristicsParameterList(){
        List<Parameter> charactristicsParameterList = new ArrayList<Parameter>();
        parameterList.stream().filter(p -> p.isEqualsToParameterType(ParameterType.CHARACTERISTICS)).forEach(e -> charactristicsParameterList.add(e));
        return charactristicsParameterList;
    }

    /**
     * ステータスのリストを返却する。
     *
     * @return ステータスパラメータリスト
     */
    public List<Parameter> getStatusList(){
        List<Parameter> statusList = new ArrayList<Parameter>();

        parameterList.stream().filter(p -> p.isEqualsToParameterType(ParameterType.SANITY_POINTS)).forEach(e -> statusList.add(e));
        parameterList.stream().filter(p -> p.isEqualsToParameterType(ParameterType.MAGIC_POINTS)).forEach(e -> statusList.add(e));
        parameterList.stream().filter(p -> p.isEqualsToParameterType(ParameterType.HIT_POINTS)).forEach(e -> statusList.add(e));
        return statusList;
    }

    /**
     * 技能のリストを返却する。
     *
     * @return 技能パラメータリスト
     */
    public List<Parameter> getInvestigatorSkillList(){
        List<Parameter> investigatorList = new ArrayList<Parameter>();
        parameterList.stream().filter(p -> p.isEqualsToParameterType(ParameterType.INVESTIGATOR_SKILLS)).forEach(e -> investigatorList.add(e));
        return investigatorList;
    }

    /**
     * 武器を返却する。
     *
     * @return 武器パラメータリスト
     */
    public List<Parameter> getWeaponSkillList(){
        List<Parameter> weaponSkillList = new ArrayList<Parameter>();
        parameterList.stream().filter(p -> p.isEqualsToParameterType(ParameterType.WEAPONS)).forEach(e -> weaponSkillList.add(e));
        return weaponSkillList;
    }
}

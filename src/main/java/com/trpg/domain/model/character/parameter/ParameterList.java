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
    @Getter
    private ArrayList<Parameter> parameterList;

    public ParameterList(){
        parameterList = new ArrayList<Parameter>();
    }
    
    public void add(Parameter parameter){
        parameterList.add(parameter);
    }
    
    public ArrayList<Parameter> get(){
        return parameterList;
    }

    /** 能力値のリストを返却する。 */
    public List<Parameter> getCharactristicsParameterList(){
        List<Parameter> charactristicsParameterList = new ArrayList<Parameter>();
        parameterList.stream().filter(p -> p.getParameterType().equals(ParameterType.CHARACTERISTICS)).forEach(e -> charactristicsParameterList.add(e));
        return charactristicsParameterList;
    }

    /** ステータスのリストを返却する。 */
    public List<Parameter> getStatusList(){
        List<Parameter> statusList = new ArrayList<Parameter>();
        // ParameterList内のパラメータの持たせ方に問題がある
        parameterList.stream().filter(p -> p.getParameterType().equals(ParameterType.SANITY_POINTS)).forEach(e -> statusList.add(e));
        parameterList.stream().filter(p -> p.getParameterType().equals(ParameterType.MAGIC_POINTS)).forEach(e -> statusList.add(e));
        parameterList.stream().filter(p -> p.getParameterType().equals(ParameterType.HIT_POINTS)).forEach(e -> statusList.add(e));
        return statusList;
    }

    /** 技能のリストを返却する。 */
    public List<Parameter> getInvestigatorSkillList(){
        List<Parameter> investigatorList = new ArrayList<Parameter>();
        parameterList.stream().filter(p -> p.getParameterType().equals(ParameterType.INVESTIGATOR_SKILLS)).forEach(e -> investigatorList.add(e));
        return investigatorList;
    }
    /** 武器を返却する。 */
    public List<Parameter> getWeaponSkillList(){
        List<Parameter> weaponSkillList = new ArrayList<Parameter>();
        parameterList.stream().filter(p -> p.getParameterType().equals(ParameterType.WEAPONS)).forEach(e -> weaponSkillList.add(e));
        return weaponSkillList;
    }
}

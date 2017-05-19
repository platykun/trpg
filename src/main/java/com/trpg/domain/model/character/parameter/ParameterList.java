package com.trpg.domain.model.character.parameter;

import lombok.Getter;

import java.util.ArrayList;

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
}

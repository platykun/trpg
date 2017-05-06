package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * パラメータ
 *
 * @author Platykun
 */
public class Parameter {
    @Getter
    private int id;
    @Getter
    private ParameterPattern parameterPattern;
    @Getter
    private int parameter;
    @Getter
    private String diceParameter;

    Parameter(int id,int parameter, ParameterPattern parameterPattern){
        this.id = id;
        this.parameter = parameter;
        diceParameter = null;
        this.parameterPattern = parameterPattern;
    }
    Parameter(int id,String diceParameter, ParameterPattern parameterPattern){
        this.id = id;
        this.parameter = -1;
        diceParameter = diceParameter;
        this.parameterPattern = parameterPattern;
    }
}

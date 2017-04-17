package com.trpg.domain.model.character.parameter;

/**
 * パラメータ
 *
 * @author Platykun
 */
public abstract class Parameter {
    private ParameterPattern parameterPattern;

    Parameter(ParameterPattern parameterPattern){
        this.parameterPattern = parameterPattern;
    }
}

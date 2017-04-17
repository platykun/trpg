package com.trpg.domain.model.character.parameter;

/**
 * デフォルトのパラメータ
 *
 * @author Platykun
 */
public class DefaultParameter extends Parameter{
    private int param;

    DefaultParameter(ParameterPattern parameterPattern, int param){
        super(parameterPattern);
        this.param = param;
    }
}

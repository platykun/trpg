package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * デフォルトのパラメータ
 *
 * @author Platykun
 */
public class DefaultParameter extends Parameter{
    @Getter
    private int param;

    DefaultParameter(int id, ParameterPattern parameterPattern, int param){
        super(id, parameterPattern);
        this.param = param;
    }
}

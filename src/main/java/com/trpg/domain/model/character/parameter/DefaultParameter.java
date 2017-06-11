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

    DefaultParameter(int id, int param, ParameterPattern parameterPattern){
        super(id, param, parameterPattern);
        this.param = param;
    }
}

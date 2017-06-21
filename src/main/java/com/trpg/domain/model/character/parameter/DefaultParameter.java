package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * デフォルトのパラメータ<br>
 * 数字パラメータを持つ。
 *
 * @author Platykun
 */
public class DefaultParameter extends Parameter{
    /** パラメータ */
    @Getter
    private int param;

    DefaultParameter(int id, int param, ParameterPattern parameterPattern){
        super(id, param, parameterPattern);
        this.param = param;
    }
}

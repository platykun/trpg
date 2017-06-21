package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * 開始時にダイスを振ってパラメータを決定するタイプのパラメータ。
 *
 * @author Platykun
 */
public class DiceValueParameter extends Parameter{
    /** ダイス値 */
    @Getter
    private String diceValue;

    DiceValueParameter(int id ,ParameterPattern parameterPattern, String diceValue){
        super(id, diceValue, parameterPattern);
        this.diceValue = diceValue;
    }
}

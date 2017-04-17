package com.trpg.domain.model.character.parameter;

/**
 * デフォルトのパラメータ
 *
 * @author Platykun
 */
public class DiceValueParameter extends Parameter{
    private String diceValue;

    DiceValueParameter(ParameterPattern parameterPattern, String diceValue){
        super(parameterPattern);
        this.diceValue = diceValue;
    }
}

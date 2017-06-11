package com.trpg.domain.model.character.parameter;

/**
 * デフォルトのパラメータ
 *
 * @author Platykun
 */
public class DiceValueParameter extends Parameter{
    private String diceValue;

    DiceValueParameter(int id ,ParameterPattern parameterPattern, String diceValue){
        super(id, diceValue, parameterPattern);
        this.diceValue = diceValue;
    }
}

package com.trpg.domain.model.character.parameter;

import java.util.Map;

/**
 * パラメータパターンオブジェクトを作成する
 * 
 * @author Platykun
 *
 */
public class ParameterFactory {    
    public DefaultParameter createDefaultParameter(ParameterPattern parameterPattern, int param){
        DefaultParameter defaultParameter = new DefaultParameter(parameterPattern, param);
        return defaultParameter;
    }
    
    public DiceValueParameter createDiceValueParameter(ParameterPattern parameterPattern, String diceValue){
        DiceValueParameter diceValueParameter = new DiceValueParameter(parameterPattern, diceValue);
        return diceValueParameter;
    }
}

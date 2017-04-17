package com.trpg.domain.model.character.parameter;

import java.util.Map;

/**
 * パラメータパターンオブジェクトを作成する
 * 
 * @author Platykun
 *
 */
public class ParameterFactory {

    private ParameterPatternFactory parameterPatternFactory = new ParameterPatternFactory();

    public DefaultParameter createDefaultParameter(Map<String, String> paramMap) {
        ParameterPattern pattern = parameterPatternFactory.create(paramMap);
        String param = paramMap.get("parameter");
        DefaultParameter defaultParameter = new DefaultParameter(pattern, Integer.parseInt(param));
        return defaultParameter;
    }

    public DiceValueParameter createDiceValueParameter(Map<String, String> paramMap){
        ParameterPattern pattern = parameterPatternFactory.create(paramMap);
        String param = paramMap.get("parameter");
        DiceValueParameter diceValueParameter = new DiceValueParameter(pattern, param);
        return diceValueParameter;
    }
}

package com.trpg.domain.model.character.parameter;

import groovy.util.logging.Commons;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * パラメータパターンオブジェクトを作成する
 * 
 * @author Platykun
 *
 */
@Component
public class ParameterFactory {    
    public Parameter createDefaultParameter(int id, ParameterPattern parameterPattern, int param){
        Parameter defaultParameter = new Parameter(id, param, parameterPattern);
        return defaultParameter;
    }
    
    public Parameter createDiceValueParameter(int id, ParameterPattern parameterPattern, String diceValue){
        Parameter diceValueParameter = new Parameter(id, diceValue, parameterPattern);
        return diceValueParameter;
    }
}

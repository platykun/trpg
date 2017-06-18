package com.trpg.domain.model.character.parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * 能力値パラメータ
 * 
 * @author Platykun
 *
 */
public class CharactristicsParameter extends ParameterPattern {

    CharactristicsType charactristicsType;

    CharactristicsParameter(ParameterType type, int defaultValue, CharactristicsType charactristicsType){
        super(type, defaultValue);
        this.charactristicsType = charactristicsType;
    }

    @Override
    public String getName(){
        return charactristicsType.getName();
    }

    @Override
    public int getInitValue(){
        return charactristicsType.getInitValue();
    }
}

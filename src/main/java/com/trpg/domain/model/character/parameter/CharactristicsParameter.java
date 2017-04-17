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
    
    public Map<String, String> paramMap(){
        Map<String, String> map = super.paramMap();
        //TODO: 追加のパラメータを付与
        return map;
    }
}

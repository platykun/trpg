package com.trpg.domain.model.character.parameter;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import org.codehaus.groovy.util.StringUtil;

/**
 * パラメータコード
 * 
 * @author Platykun
 *
 */
public class ParameterPattern {
    @Getter
    private ParameterType parameterType;
    @Getter
    private int defaultValue;
    
    ParameterPattern(ParameterType type, int defaultValue){
        this.parameterType = type;
        this.defaultValue = defaultValue;
    }
    
    public Map<String, String> paramMap(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("parameterType", parameterType.toString());
        map.put("defaultValue",Integer.toString(defaultValue));
        return map;
    }

    public int getSubParameterTypeValue(){
        return 0;
    }

    public String getName(){
        return parameterType.getName();
    }

    public int getInitValue(){
        return parameterType.getInitValue();
    }
}

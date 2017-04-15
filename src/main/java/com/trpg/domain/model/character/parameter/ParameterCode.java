package com.trpg.domain.model.character.parameter;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.groovy.util.StringUtil;

/**
 * パラメータコード
 * 
 * @author Platykun
 *
 */
public class ParameterCode {
    private ParameterType parameterType;
    
    private int parameterCode;
    
    private int defaultValue;
    
    ParameterCode(ParameterType type, int defaultValue){
        this.parameterType = type;
        this.defaultValue = defaultValue;
    }
    
    public Map<String, String> paramMap(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("parameterType", parameterType.toString());
        map.put("defaultValue",Integer.toString(defaultValue));
        return map;
    }
}

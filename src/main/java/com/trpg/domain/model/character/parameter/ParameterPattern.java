package com.trpg.domain.model.character.parameter;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import org.codehaus.groovy.util.StringUtil;

/**
 * パラメータパターン。
 * 
 * @author Platykun
 *
 */
public class ParameterPattern {

    /** パラメータ種別 */
    @Getter
    private ParameterType parameterType;
    /** デフォルト値 */
    @Getter
    private int defaultValue;
    
    ParameterPattern(ParameterType type, int defaultValue){
        this.parameterType = type;
        this.defaultValue = defaultValue;
    }

    /** サブパラメータ種別IDを取得する。
     * @return サブパラメータ種別ID
     * */
    public int getSubParameterTypeValue(){
        return 0;
    }

    /**
     * パラメータ名を取得する。
     * @return パラメータ名。
     */
    public String getName(){
        return parameterType.getName();
    }

    /**
     * 初期値を取得する。
     *
     * @return 初期値
     */
    public int getInitValue(){
        return parameterType.getInitValue();
    }
}

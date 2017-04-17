package com.trpg.domain.model.character.parameter;

import java.util.Map;

/**
 * 正気度パラメータ
 * 
 * @author Platykun
 *
 */
public class SanityPointsParameter extends ParameterPattern {

    //TODO: 正気度パラメータ特有の業務ロジックもここに仕込む。
    SanityPointsParameter(ParameterType type, int defaultValue){
        super(type, defaultValue);
    }
    
    public Map<String, String> paramMap(){
        Map<String, String> map = super.paramMap();
        //TODO: 追加のパラメータを付与
        return map;
    }
}

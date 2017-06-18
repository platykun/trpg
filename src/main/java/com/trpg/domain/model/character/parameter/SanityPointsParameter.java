package com.trpg.domain.model.character.parameter;

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
}

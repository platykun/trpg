package com.trpg.domain.model.character.parameter;

import java.util.Map;

/**
 *  体力パラメータ
 * 
 * @author Platykun
 *
 */
public class HitPointsParameter extends ParameterPattern {

    //TODO: 体力パラメータ特有の業務ロジックもここに仕込む。
    HitPointsParameter(ParameterType type, int defaultValue){
        super(type, defaultValue);
    }
}

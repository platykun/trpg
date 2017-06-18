package com.trpg.domain.model.character.parameter;

import java.util.Map;

/**
 * マジックポイントパラメータ
 * 
 * @author Platykun
 *
 */
public class MagicPointsParameter extends ParameterPattern {

    //TODO: マジックポイントパラメータ特有の業務ロジックもここに仕込む。
    MagicPointsParameter(ParameterType type, int defaultValue){
        super(type, defaultValue);
    }
}

package com.trpg.domain.model.character.parameter;

/**
 * 能力値パラメータ
 * 
 * @author Platykun
 *
 */
public class CharactristicsParameter extends ParameterPattern {

    /** パラメータ種別 */
    CharactristicsType charactristicsType;

    CharactristicsParameter(ParameterType type, int defaultValue, CharactristicsType charactristicsType){
        super(type, defaultValue);
        this.charactristicsType = charactristicsType;
    }

    /** 名前を取得する。 */
    @Override
    public String getName(){
        return charactristicsType.getName();
    }

    /** 初期値を取得する。 */
    @Override
    public int getInitValue(){
        return charactristicsType.getInitValue();
    }
}

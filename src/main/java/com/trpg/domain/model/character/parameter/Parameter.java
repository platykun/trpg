package com.trpg.domain.model.character.parameter;

import lombok.Getter;

/**
 * パラメータ
 *
 * @author Platykun
 */
public class Parameter {


    /** パラメータID */
    @Getter
    private int id;

    /** パラメータパターン
     * パラメータパターンはパラメータドメインから間接的にアクセスさせるため
     * getterを用意しない。
     * */
    private ParameterPattern parameterPattern;
    /** パラメータ値 */
    @Getter
    private int parameter;
    /** ダイスパラメータ値 */
    @Getter
    private String diceParameter;

    Parameter(int id,int parameter, ParameterPattern parameterPattern){
        this.id = id;
        this.parameter = parameter;
        diceParameter = null;
        this.parameterPattern = parameterPattern;
    }
    Parameter(int id,String diceParameter, ParameterPattern parameterPattern){
        this.id = id;
        this.parameter = -1;
        this.diceParameter = diceParameter;
        this.parameterPattern = parameterPattern;
    }

    /**
     * パラメータ種別を取得する。
     * @return パラメータ種別
     * */
    public ParameterType getParameterType() {
        return parameterPattern.getParameterType();
    }

    /**
     * パラメータ名を取得する。
     * @return パラメータ名
     */
    public String getParameterPatternName() {
      return parameterPattern.getName();
    }

    /**
     * パラメータのサブ種別IDを取得する。
     * @return パラメータサブ種別ID
     */
    public int getSubParameterTypeValue() {
        return parameterPattern.getSubParameterTypeValue();
    }

    /**
     * パラメータのデフォルト値を取得する。
     * @return デフォルト値
     * */
    public int getDefaultValue() {
        return parameterPattern.getDefaultValue();
    }
}

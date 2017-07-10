package com.trpg.domain.model.character.parameter;

import com.trpg.domain.model.character.belonging.WeaponType;


/**
 *  武器パラメータ
 * 
 * @author Platykun
 *
 */
public class WeaponParameter extends ParameterPattern {

    /** 武器種別 */
    WeaponType weaponType;

    WeaponParameter(int defaultValue, WeaponType weaponType){
        super(ParameterType.WEAPONS, defaultValue);
        this.weaponType = weaponType;
    }

    /**
     * サブパラメータ種別IDを取得する。
     * @return サブパラメータ種別ID
     */
    @Override
    public int getSubParameterTypeValue(){
        return weaponType.getId();
    }

    /** 名前を取得する。 */
    @Override
    public String getName(){
        return weaponType.getName();
    }

    /** 初期値を取得する。 */
    @Override
    public int getInitValue(){
        return weaponType.getInitValue();
    }
}

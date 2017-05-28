package com.trpg.domain.model.character.parameter;

import com.trpg.domain.model.character.belonging.Weapon;
import com.trpg.domain.model.character.belonging.WeaponType;

import java.util.Map;

/**
 *  技能パラメータ
 * 
 * @author Platykun
 *
 */
public class WeaponParameter extends ParameterPattern {

    WeaponType weaponType;

    WeaponParameter(int defaultValue, WeaponType weaponType){
        super(ParameterType.WEAPONS, defaultValue);
        this.weaponType = weaponType;
    }
    
    public Map<String, String> paramMap(){
        Map<String, String> map = super.paramMap();
        //TODO: 追加のパラメータを付与
        return map;
    }
}

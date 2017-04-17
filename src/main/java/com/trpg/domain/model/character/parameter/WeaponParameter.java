package com.trpg.domain.model.character.parameter;

import com.trpg.domain.model.character.belonging.Weapon;

import java.util.Map;

/**
 *  技能パラメータ
 * 
 * @author Platykun
 *
 */
public class WeaponParameter extends ParameterPattern {

    Weapon weapon;

    WeaponParameter(ParameterType type, int defaultValue, Weapon weapon){
        super(type, defaultValue);
        this.weapon = weapon;
    }
    
    public Map<String, String> paramMap(){
        Map<String, String> map = super.paramMap();
        //TODO: 追加のパラメータを付与
        return map;
    }
}

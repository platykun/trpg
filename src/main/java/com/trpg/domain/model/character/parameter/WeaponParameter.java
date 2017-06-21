package com.trpg.domain.model.character.parameter;

import com.trpg.domain.model.character.belonging.Weapon;
import com.trpg.domain.model.character.belonging.WeaponType;

import java.util.Map;

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
}

package com.trpg.domain.model.character.belonging;

import java.util.Map;

/**
 * 所持品オブジェクトを作成する
 * 
 * @author Platykun
 *
 */
public class WeaponFactory {
    public Weapon create(int weaponId, int belongingId, BelongingType type, String name, String description, int accuracy, int damage, int range, String remarks){
        Weapon weapon = new Weapon(weaponId, belongingId, type, name, description, accuracy, damage, range, remarks);
        return weapon;
    }
}

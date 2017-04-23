package com.trpg.domain.model.character.belonging;

import java.util.Map;

/**
 * 所持品オブジェクトを作成する
 * 
 * @author Platykun
 *
 */
public class BelongingFactory {
    public Belonging createBelonging(BelongingType belongingType, String name, String description){
        Belonging belonging = new Belonging(belongingType, name, description);
        return belonging;
    }
    
    public Weapon createWeapon(String name, String description, int accuracy, int damage, int range, String remarks){
        Weapon weapon = new Weapon(BelongingType.WEAPONS, name, description, accuracy, damage, range, remarks);
        return weapon;
    }
}

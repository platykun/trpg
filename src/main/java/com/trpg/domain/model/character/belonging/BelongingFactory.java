package com.trpg.domain.model.character.belonging;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 所持品オブジェクトを作成する
 * 
 * @author Platykun
 *
 */
@Component
public class BelongingFactory {
    public Belonging createBelonging(int belongingId, BelongingType belongingType, String name, String description){
        Belonging belonging = new Belonging(belongingId, belongingType, name, description);
        return belonging;
    }
    
    public Weapon createWeapon(int weaponId, int belongingId, String name, String description, int accuracy, int damage, int range, String remarks){
        Weapon weapon = new Weapon(weaponId, belongingId, BelongingType.WEAPONS, name, description, accuracy, damage, range, remarks);
        return weapon;
    }
}

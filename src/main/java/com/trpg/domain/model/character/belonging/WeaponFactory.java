package com.trpg.domain.model.character.belonging;

import java.util.Map;

/**
 * 所持品オブジェクトを作成する
 * 
 * @author Platykun
 *
 */
public class WeaponFactory {
    public Weapon create(Map<String, String> paramMap){
        String type = paramMap.get("belongingType");
        
        //武器以外の所持品種別は認めない
        if(!BelongingType.WEAPONS.equals(BelongingType.valueOf(type))){
            return null;
        }
        
        Weapon weapon =  createWeaponFromMap(paramMap);
        return weapon;
    }
    
    private Weapon createWeaponFromMap(Map<String, String> map){
        BelongingType type = BelongingType.valueOf(map.get("belongingType"));
        String name = map.get("name");
        String description = map.get("description");
        int accuracy = Integer.parseInt(map.get("accuracy"));
        int damage = Integer.parseInt(map.get("damage"));
        int range = Integer.parseInt(map.get("range"));
        String remarks = map.get("remarks");
        Weapon weapon = new Weapon(type, name, description, accuracy, damage, range, remarks);
        return weapon;
    }
}

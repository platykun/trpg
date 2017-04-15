package com.trpg.domain.model.character.belonging;

import java.util.Map;

/**
 * 所持品オブジェクトを作成する
 * 
 * @author Platykun
 *
 */
public class BelongingFactory {
    Belonging create(Map<String, String> paramMap){
        String type = paramMap.get("belongingType");
        
        Belonging belonging = null;
        switch(BelongingType.valueOf(type)){
        case WEAPONS : belonging = createWeaponFromMap(paramMap);
            default : belonging = createBelongingDefaultFromMap(paramMap);
        }
        return belonging;
    }
    
    private Belonging createBelongingDefaultFromMap(Map<String, String> map){
        BelongingType type = BelongingType.valueOf(map.get("belongingType"));
        String name = map.get("name");
        String description = map.get("description");
        Belonging belonging = new Belonging(type, name, description);
        return belonging;
    }
    
    private Belonging createWeaponFromMap(Map<String, String> map){
        BelongingType type = BelongingType.valueOf(map.get("belongingType"));
        String name = map.get("name");
        String description = map.get("description");
        int accuracy = Integer.parseInt(map.get("accuracy"));
        int damage = Integer.parseInt(map.get("damage"));
        int range = Integer.parseInt(map.get("range"));
        String remarks = map.get("remarks");
        Belonging belonging = new Weapon(type, name, description, accuracy, damage, range, remarks);
        return belonging;
    }
}

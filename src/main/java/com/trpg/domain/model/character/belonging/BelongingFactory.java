package com.trpg.domain.model.character.belonging;

import org.springframework.stereotype.Component;

/**
 * 所持品ドメインを作成するファクトリクラス。
 * 
 * @author Platykun
 *
 */
@Component
public class BelongingFactory {
    /**
     * 所持品オブジェクトを作成する。
     * @param belongingId 所持品ID
     * @param belongingType 所持品種別
     * @param name 名前
     * @param description 説明
     * @return 所持品オブジェクト
     * */
    public Belonging createBelonging(int belongingId, BelongingType belongingType, String name, String description){
        Belonging belonging = new Belonging(belongingId, belongingType, name, description);
        return belonging;
    }

    /**
     * 武器オブジェクトを作成する。
     * @param weaponId 武器ID
     * @param belongingId 所持品ID
     * @param name 武器名
     * @param description 説明
     * @param accuracy 命中率
     * @param damage ダメージ
     * @param range 射程
     * @param remarks 備考
     * @return 武器オブジェクト
     * */
    public Weapon createWeapon(int weaponId, int belongingId, String name, String description, int accuracy, int damage, int range, String remarks){
        Weapon weapon = new Weapon(weaponId, belongingId, BelongingType.WEAPONS, name, description, accuracy, damage, range, remarks);
        return weapon;
    }
}

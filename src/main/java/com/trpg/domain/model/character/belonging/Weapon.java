package com.trpg.domain.model.character.belonging;

import lombok.Getter;

/**
 * 武器ドメインオブジェクト。
 * 
 * @author Platykun
 *
 */
public class Weapon extends Belonging{

    /** 武器ID */
    @Getter
    private int weaponId;
    /** 命中率 */
    @Getter
    private int accuracy;
    /** ダメージ */
    @Getter
    private int damage;
    /** 射程 */
    @Getter
    private int range;
    /** 備考 */
    @Getter
    private String remarks;

    Weapon(int weaponId, int belongingId, BelongingType type, String name, String description, int accuracy, int damage, int range, String remarks) {
        super(belongingId, type, name, description);

        //BelongingTypeが武器であることの精査処理。
        if(!BelongingType.WEAPONS.equals(type)){
            //TODO: throw句を追加
            // throw new IllegalAccessException("武器種別以外の種別が選択されました。");
        }

        this.weaponId = weaponId;
        this.accuracy = accuracy;
        this.damage = damage;
        this.range = range;
        this.remarks = remarks;
    }
}

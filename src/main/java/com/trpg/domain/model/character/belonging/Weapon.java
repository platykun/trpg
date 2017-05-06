package com.trpg.domain.model.character.belonging;

import lombok.Getter;

import java.util.Map;

/**
 * 武器の抽象クラス
 * 
 * @author Platykun
 *
 */
public class Weapon extends Belonging{

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
        // TODO Auto-generated constructor stub
        if(!BelongingType.WEAPONS.equals(type)){
            //WEAPONS以外の場合エラー
        }
        this.weaponId = weaponId;
        this.accuracy = accuracy;
        this.damage = damage;
        this.range = range;
        this.remarks = remarks;
    }
    
    public Map<String, String> paramMap(){
        Map<String, String> map = super.paramMap();
        map.put("accuracy", String.valueOf(accuracy));
        map.put("damage", String.valueOf(damage));
        map.put("range", String.valueOf(range));
        map.put("remarks", remarks);
        return map;
    }
}

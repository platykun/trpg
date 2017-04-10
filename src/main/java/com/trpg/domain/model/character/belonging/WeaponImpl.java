package com.trpg.domain.model.character.belonging;

import java.util.Map;

/**
 * 武器の抽象クラス
 * 
 * @author Platykun
 *
 */
public class WeaponImpl extends BelongingDefaultImpl{
    
    /** 命中率 */
    private int accuracy;
    /** ダメージ */
    private int damage;
    /** 射程 */
    private int range;
    /** 備考 */
    private String remarks;
    
    WeaponImpl(BelongingType type, String name, String description, int accuracy, int damage, int range, String remarks){
        super(BelongingType.WEAPONS, name, description);
        if(!BelongingType.WEAPONS.equals(type)){
            //WEAPONS以外の場合エラー
        }
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

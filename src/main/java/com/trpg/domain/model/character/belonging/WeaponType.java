package com.trpg.domain.model.character.belonging;

import lombok.Getter;

/**
 * 武器種別。
 * 
 * @author platykun
 */
public enum WeaponType {
    GUN(0,"拳銃",20),
    SUBMACHINEGUN(1,"サブマシンガン",15),
    SHOTGUN(2,"ショットガン",30),
    MACHINEGUN(3,"マシンガン",15),
    RIFLE(4,"ライフル",25),
    KICK(5, "キック", 25),
    ASSEMBLY(6, "組み付き", 25),
    FIRST(7, "こぶし", 50),
    HEADBUTT(8, "頭突き", 10),
    HANDWEAPON1(9, "近接戦1", 0),
    HANDWEAPON2(10, "近接戦1", 0),
    FIREARM1(11, "火器1", 0),
    FIREARM2(12, "火器2", 0),
    FIREARM3(13, "火器3", 0),
    FIREARM4(14, "火器4", 0),
    FIREARM5(15, "火器5", 0),
    FIREARM6(16, "火器6", 0);

    /** 武器種別 */
    @Getter
    private final int id;
    /** 武器名 */
    @Getter
    private final String name;
    /** 初期値 */
    @Getter
    private final int initValue;

    private WeaponType(final int id, final String name, final int initValue){
        this.id = id;
        this.name = name;
        this.initValue = initValue;
    }

    /**
     * 引数のIDに合致した武器種別オブジェクトを返却する。<br>
     * IDが存在：種別を返却。<br>
     * IDが存在しない：nullを返却。
     *
     * @param id 武器ID
     * @return 武器種別
     */
    public static WeaponType getType(final int id){
        WeaponType[] types = WeaponType.values();
        for(WeaponType type : types){
            if(type.getId() ==  id){
                return type;
            }
        }
        return null;
    }
}

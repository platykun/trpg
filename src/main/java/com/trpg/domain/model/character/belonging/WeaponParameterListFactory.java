package com.trpg.domain.model.character.belonging;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 武器オブジェクトリストを作成する
 * 
 * @author Platykun
 *
 */
public class WeaponParameterListFactory {
    @Autowired
    private WeaponFactory weaponFactory;

//    public List<Weapon> createInitialWeaponList(){
//        for(WeaponType type : WeaponType.values()){
//            weaponFactory.create()
//        }
//    }
}

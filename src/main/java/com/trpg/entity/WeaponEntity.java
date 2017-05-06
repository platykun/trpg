package com.trpg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Weaponテーブルのエンティティクラス
 */

@Entity
@Table(name = "weapon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeaponEntity {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int accuracy;

    private int damage;

    private int range;

    private int remarks;
}

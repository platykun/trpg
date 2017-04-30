package com.trpg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * parameterテーブルのエンティティクラス
 */

@Entity
@Table(name = "parameter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParameterEntity {
    @Id
    @GeneratedValue
    private int id;

    private int characterId;

    private int parameter;

    private String diceValue;

    private int parameterType;

    private int defaultValue;

    private int subParameterType;
}

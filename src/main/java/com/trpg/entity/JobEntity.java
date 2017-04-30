package com.trpg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Jobテーブルのエンティティクラス
 */

@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobEntity {
    @Id
    @GeneratedValue
    private int id;

    private String name;
}

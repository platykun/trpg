package com.trpg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JobDetailテーブルのエンティティクラス
 */

@Entity
@Table(name = "job_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDetailEntity {
    @Id
    @GeneratedValue
    private int id;

    private int investigateType;
}

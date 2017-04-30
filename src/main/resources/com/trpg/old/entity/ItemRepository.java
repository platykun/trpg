package com.trpg.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * アイテム情報のRepositoryクラス
 */
public interface ItemRepository extends JpaRepository<Item, Integer>{
}

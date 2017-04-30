package com.trpg.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * キャラクター情報を検索するためのRepositoryクラス
 */
public interface CharacterInfoRepository extends JpaRepository<CharacterInfo, Integer> {
}

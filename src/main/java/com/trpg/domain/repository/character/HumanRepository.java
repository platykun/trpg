package com.trpg.domain.repository.character;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trpg.entity.HumanEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 探索者リポジトリ。
 */
@Repository
public interface HumanRepository extends JpaRepository<HumanEntity, Integer> {
    /**
     * キャラクタIDをもとに探索者を取得する。
     * @param characterId キャラクタID
     * @return 探索者
     */
    List<HumanEntity> findByCharacterId(int characterId);
}

package com.trpg.domain.repository.character;

import com.trpg.entity.BelongingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 所持品リポジトリ。
 */
@Repository
public interface BelongingRepository extends JpaRepository<BelongingEntity, Integer> {
    /**
     * キャラクターIDをもとに所持品を取得する。
     *
     * @param characterId キャラクタID
     * @return 所持品リスト
     */
    List<BelongingEntity> findByCharacterId(int characterId);
}

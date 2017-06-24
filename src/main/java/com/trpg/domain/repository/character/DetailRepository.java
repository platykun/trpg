package com.trpg.domain.repository.character;

import com.trpg.entity.DetailEntity;
import com.trpg.entity.HumanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 探索者詳細リポジトリ。
 */
@Repository
public interface DetailRepository extends JpaRepository<DetailEntity, Integer> {
    /**
     * 探索者IDをもとに探索者詳細を取得する。
     * @param humanId 探索者ID
     * @return 探索者詳細リスト
     */
    List<DetailEntity> findByHumanId(int humanId);
}

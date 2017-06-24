package com.trpg.domain.repository.character;

import com.trpg.entity.ParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * パラメータリポジトリ。
 */
@Repository
public interface ParameterRepository extends JpaRepository<ParameterEntity, Integer> {
    /**
     * キャラクターIDをもとにパラメータを取得する。
     *
     * @param characterId　キャラクタID
     * @return パラメータリスト
     */
    List<ParameterEntity> findByCharacterId(int characterId);
}

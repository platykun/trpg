package com.trpg.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * シーン情報のRepositoryクラス
 */
public interface SceneRepository extends JpaRepository<Scene, Integer> {
}

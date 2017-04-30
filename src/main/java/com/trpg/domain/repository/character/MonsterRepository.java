package com.trpg.domain.repository.character;

import com.trpg.entity.MonsterEntity;
import com.trpg.entity.WeaponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<MonsterEntity, Integer> {
}

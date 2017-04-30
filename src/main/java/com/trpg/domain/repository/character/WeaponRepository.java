package com.trpg.domain.repository.character;

import com.trpg.entity.JobDetailEntity;
import com.trpg.entity.WeaponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<WeaponEntity, Integer> {
}

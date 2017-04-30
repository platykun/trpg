package com.trpg.domain.repository.character;

import com.trpg.entity.BelongingEntity;
import com.trpg.entity.HumanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BelongingRepository extends JpaRepository<BelongingEntity, Integer> {
}

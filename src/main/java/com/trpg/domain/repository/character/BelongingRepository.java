package com.trpg.domain.repository.character;

import com.trpg.entity.BelongingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BelongingRepository extends JpaRepository<BelongingEntity, Integer> {
}

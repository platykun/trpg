package com.trpg.domain.repository.character;

import com.trpg.entity.DetailEntity;
import com.trpg.entity.HumanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<DetailEntity, Integer> {
}

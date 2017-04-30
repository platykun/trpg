package com.trpg.domain.repository.character;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trpg.entity.HumanEntity;

public interface HumanRepository extends JpaRepository<HumanEntity, Integer> {
}

package com.trpg.domain.repository.character;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trpg.entity.HumanEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends JpaRepository<HumanEntity, Integer> {
}

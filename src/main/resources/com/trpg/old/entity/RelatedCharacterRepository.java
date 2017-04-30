package com.trpg.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatedCharacterRepository extends JpaRepository<RelatedCharacter, Integer>{
	List<RelatedCharacter> findByScenarioIdStartingWith(int scenarioId);
}

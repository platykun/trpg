package com.trpg.domain.repository.character;

import com.trpg.entity.CharacterInfoEntity;
import com.trpg.entity.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterInfoRepository extends JpaRepository<CharacterInfoEntity, Integer> {
}
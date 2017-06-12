package com.trpg.domain.repository.character;

import com.trpg.entity.DetailEntity;
import com.trpg.entity.HumanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<DetailEntity, Integer> {
}

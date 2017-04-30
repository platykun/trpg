package com.trpg.domain.repository.character;

import com.trpg.entity.HumanEntity;
import com.trpg.entity.JobDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDetailRepository extends JpaRepository<JobDetailEntity, Integer> {
}

package com.trpg.domain.repository.character;

import com.trpg.entity.HumanEntity;
import com.trpg.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Integer> {
}

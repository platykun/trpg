package com.trpg.domain.repository.character;

import com.trpg.entity.JobDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDetailRepository extends JpaRepository<JobDetailEntity, Integer> {
}

package com.trpg.domain.repository.character;

import com.trpg.entity.ParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<ParameterEntity, Integer> {
}

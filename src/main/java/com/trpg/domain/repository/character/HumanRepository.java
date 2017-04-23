package com.trpg.domain.repository.character;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trpg.domain.model.character.character.Human;

public interface HumanRepository extends JpaRepository<Human, Integer> {
    @Query("SELECT X FROM HUMAN X")
    Page<Human> findAllOutline(Pageable pageable);
}

package com.trpg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import com.trpg.domain.model.character.character.Human;
import com.trpg.domain.repository.character.HumanRepository;
import com.trpg.entity.HumanEntity;

@Controller
public class CharacterService {
    
    @Autowired
    HumanRepository humanRepository;
    
    public Page<Human> findAllOutline(){
        
        Page<HumanEntity> humanEntity = humanRepository.findAll(new PageRequest(0, 20));
        List<HumanEntity> a = humanEntity.getContent();
        //humanEntity→enitty
        return null;
    }
}

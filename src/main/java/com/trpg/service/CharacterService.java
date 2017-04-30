package com.trpg.service;

import java.util.List;

import com.trpg.domain.model.character.character.HumanFactory;
import com.trpg.domain.model.character.character.HumanList;
import com.trpg.domain.repository.character.CharacterInfoRepository;
import com.trpg.entity.CharacterInfo;
import com.trpg.entity.CharacterInfoEntity;
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

    @Autowired
    CharacterInfoRepository characterInfoRepository;

    @Autowired
    HumanFactory humanFactory;
    
    public HumanList findAllOutline(){
        
        Page<HumanEntity> humanEntityPage = humanRepository.findAll(new PageRequest(0, 20));
        List<HumanEntity> humanEntityList = humanEntityPage.getContent();

        HumanList humanList = new HumanList();
        for(HumanEntity humanEntity: humanEntityList){
            CharacterInfoEntity characterInfoEntity = characterInfoRepository.getOne(humanEntity.getCharacterId());
            Human human = convertToHumanOutline(humanEntity, characterInfoEntity);
            humanList.add(human);
        }
        return humanList;
    }

    private Human convertToHumanOutline(HumanEntity h, CharacterInfoEntity c){
        Human human = humanFactory.create(
                c.getName(),
                null,
                null,
                null,
                h.getSchool(),
                h.getComeFrom(),
                h.getMentalDisorder(),
                h.getSex(),
                h.getAge(),
                null,
                null
        );
        return human;
    }
}

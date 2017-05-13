package com.trpg.service;

import java.util.List;

import com.trpg.domain.model.character.belonging.Belonging;
import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.character.*;
import com.trpg.domain.model.character.character.Character;
import com.trpg.domain.model.character.parameter.Parameter;
import com.trpg.domain.model.character.parameter.ParameterList;
import com.trpg.domain.repository.character.*;
import com.trpg.entity.*;
import com.trpg.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

@Controller
public class CharacterService {
    
    @Autowired
    HumanRepository humanRepository;

    @Autowired
    CharacterInfoRepository characterInfoRepository;

    @Autowired
    DetailRepository detailRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    BelongingRepository belongingRepository;

    @Autowired
    ParameterRepository parameterRepository;

    @Autowired
    HumanFactory humanFactory;

    public HumanList findAllOutline(){
        Page<HumanEntity> humanEntityPage = humanRepository.findAll(new PageRequest(0, 20));
        List<HumanEntity> humanEntityList = humanEntityPage.getContent();

        HumanList humanList = new HumanList();
        for(HumanEntity humanEntity: humanEntityList){
            CharacterInfoEntity characterInfoEntity = characterInfoRepository.getOne(humanEntity.getCharacterId());
            Human human = HumanMapper.toDetailDomain(humanEntity, characterInfoEntity);
            humanList.add(human);
        }
        return humanList;
    }

    public Human getInitialValueHuman(){
        return null;
    }

    public void insertHuman(Human human, List<Detail> detailList){

        // characterInfoテーブルへ登録
        CharacterInfoEntity characterInfoEntity = CharacterInfoMapper.toEntity((Character)human);
        CharacterInfoEntity afterCharacterInfoEntity = characterInfoRepository.save(characterInfoEntity);
        int characterId = afterCharacterInfoEntity.getId();

        // humanテーブルへ登録
        HumanEntity humanEntity = HumanMapper.toEntity(human);
        humanEntity.setCharacterId(characterId);
        HumanEntity afterHumanEntity = humanRepository.save(humanEntity);

        //Detailテーブルへ登録
        for(Detail detail : detailList){
            DetailEntity detailEntity = DetailMapper.toEntity(characterId, detail);
            detailRepository.save(detailEntity);
        }

        //Jobテーブルへ登録
        JobEntity jobEntity = JobMapper.toEntity(human.getJob());
        jobRepository.save(jobEntity);

        //Belongingテーブルへ登録
        BelongingList belongingList = human.getBelongingList();
        for(Belonging belonging : belongingList.getBelongings()){
            BelongingEntity belongingEntity = BelongingMapper.toEntity(belonging);
            belongingRepository.save(belongingEntity);
        }

        //Parameterテーブルへ登録
        ParameterList parameterList = human.getParameterList();
        for(Parameter parameter : parameterList.getParameterList()){
            ParameterEntity parameterEntity = ParameterMapper.toEntity(0, characterId, parameter);
            parameterRepository.save(parameterEntity);
        }
    }
}

package com.trpg.service;

import java.util.List;
import java.util.stream.Collectors;

import com.trpg.domain.model.character.character.*;
import com.trpg.domain.model.character.character.Character;
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
    JobDetailRepository jobDetailRepository;

    @Autowired
    HumanFactory humanFactory;

    @Autowired
    BelongingService belongingService;

    @Autowired
    ParameterService parameterService;

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

    // 職業一覧を取得する
    public JobList getAllJob(){
        List<JobEntity> jobEntityList = jobRepository.findAll();
        List<JobDetailEntity> jobDetailRepositoryList = jobDetailRepository.findAll();

        JobList jobList = new JobList();

        for(JobEntity jobEntity : jobEntityList){
            List<JobDetailEntity> filteredDetail = jobDetailRepositoryList.stream().filter(j -> j.getId() == jobEntity.getId()).collect(Collectors.toList());
            Job job = JobMapper.toDomain(jobEntity, filteredDetail);
            jobList.add(job);
        }

        return jobList;
    }

    // 初期値のHumanを返却する。
    public Human getInitialHuman(){
        Human human = humanFactory.createInit();
        return human;
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
        belongingService.insertBelongings(human.getBelongingList());

        //Parameterテーブルへ登録
        parameterService.insertParameter(human.getParameterList(), characterId);

    }
}

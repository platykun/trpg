package com.trpg.service;

import java.util.List;
import java.util.stream.Collectors;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.character.*;
import com.trpg.domain.model.character.character.Character;
import com.trpg.domain.model.character.parameter.ParameterList;
import com.trpg.domain.repository.character.*;
import com.trpg.entity.*;
import com.trpg.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

/**
 * 探索者管理画面向けのサービスクラス。
 */
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

    /**
     * 探索者の概要を取得する。
     *
     * @return 探索者リスト
     */
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

    /**
     * 職業一覧を取得する
     * @return 職業一覧
     */
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

    public void insertHuman(Human human){

        // characterInfoテーブルへ登録
        CharacterInfoEntity characterInfoEntity = CharacterInfoMapper.toEntity((Character)human);
        CharacterInfoEntity afterCharacterInfoEntity = characterInfoRepository.save(characterInfoEntity);
        int characterId = afterCharacterInfoEntity.getId();

        // humanテーブルへ登録
        HumanEntity humanEntity = HumanMapper.toEntity(human);
        humanEntity.setCharacterId(characterId);
        HumanEntity afterHumanEntity = humanRepository.save(humanEntity);

        //Detailテーブルへ登録
        DetailList detailList = human.getDetailList();
        for(Detail detail : detailList.getDetailList()){
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

    /**
     * キャラクタIDをもとに探索者を取得する。
     *
     * @param characterId キャラクタID
     * @return 探索者
     */
    public Human findHumanByCharacterId(int characterId){
        BelongingList belongingList = belongingService.findByCharacterId(characterId);
        ParameterList parameterList = parameterService.findByCharacterId(characterId);

        CharacterInfoEntity characterInfoEntity = characterInfoRepository.getOne(characterId);

        //探索者情報を取得する。
        List<HumanEntity> humanEntityList = humanRepository.findByCharacterId(characterId);
        HumanEntity humanEntity;
        if(humanEntityList.size() == 1){
            humanEntity = humanEntityList.get(0);
        }else{
            //TODO: humanEntityが1件のみ検出されなかった場合、例外処理を行う。
            return null;
        }

        //詳細情報を取得する。
        List<DetailEntity> detailEntityList = detailRepository.findByCharacterId(humanEntity.getCharacterId());
        DetailList detailList = new DetailList();
        detailEntityList.stream().forEach(d -> detailList.add(DetailMapper.toDomain(d)));

        // 職業情報を取得する。
        JobEntity jobEntity = jobRepository.findOne(humanEntity.getJobId());
        List<JobDetailEntity> jobDetailEntities = jobDetailRepository.findById(humanEntity.getJobId());
        Job job = JobMapper.toDomain(jobEntity, jobDetailEntities);

        // 探索者オブジェクトを作成する。
        int humanId = humanEntity.getId();
        String name = characterInfoEntity.getName();
        String school = humanEntity.getSchool();
        String comeFrom = humanEntity.getComeFrom();
        String mentalDisorder = humanEntity.getMentalDisorder();
        String sex = humanEntity.getSex();
        int age = humanEntity.getAge();
        HumanType type = HumanType.getType(humanEntity.getHumanType());
        Human human = humanFactory.create(humanId, characterId, name, parameterList, belongingList, job, school, comeFrom, mentalDisorder,sex, age, type, detailList);

        return human;
    }
}

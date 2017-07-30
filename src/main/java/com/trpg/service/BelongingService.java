package com.trpg.service;

import com.trpg.domain.model.character.belonging.Belonging;
import com.trpg.domain.model.character.belonging.BelongingFactory;
import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.belonging.BelongingListFactory;
import com.trpg.domain.model.character.parameter.*;
import com.trpg.domain.repository.character.BelongingRepository;
import com.trpg.entity.BelongingEntity;
import com.trpg.mapper.BelongingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 所持品サービスクラス
 */
@Controller
public class BelongingService {

    /** 所持品リポジトリ */
    @Autowired
    BelongingRepository belongingRepository;

    /** 所持品ファクトリ */
    @Autowired
    BelongingFactory belongingFactory;

    /** 所持品リストファクトリ */
    @Autowired
    BelongingListFactory belongingListFactory;

    /**
     * 所持品リストをDBへ登録する。
     *
     * @param belongingList 所持品リスト。
     */
    public void insertBelongings(BelongingList belongingList){
        //Belongingテーブルへ登録
        for(Belonging belonging : belongingList.getBelongings()) {
            BelongingEntity belongingEntity = BelongingMapper.toEntity(belonging);
            belongingRepository.save(belongingEntity);
        }
    }

    /**
     * 所持品リストをDBへ更新する。
     *
     * @param belongingList
     */
    public void updateBelongings(BelongingList belongingList){
        //Belongingテーブルを更新
        for(Belonging belonging : belongingList.getBelongings()) {
            BelongingEntity belongingEntity = BelongingMapper.toEntity(belonging);
            belongingRepository.save(belongingEntity);
        }
    }

    /**
     * 所持品を取得する
     *
     * @param id 所持品
     * @return 所持品リスト
     */
    public BelongingList findByCharacterId(int id){
        List<BelongingEntity> belongingEntityList = belongingRepository.findByCharacterId(id);

        BelongingList belongingList = belongingListFactory.create();
        belongingEntityList.stream().forEach(b -> belongingList.add(BelongingMapper.toDomain(b)));

        return belongingList;
    }

}

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

@Controller
public class BelongingService {

    @Autowired
    BelongingRepository belongingRepository;

    @Autowired
    BelongingFactory belongingFactory;

    @Autowired
    BelongingListFactory belongingListFactory;

    public void insertBelongings(BelongingList belongingList){
        //Belongingテーブルへ登録
        for(Belonging belonging : belongingList.getBelongings()) {
            BelongingEntity belongingEntity = BelongingMapper.toEntity(belonging);
            belongingRepository.save(belongingEntity);
        }
    }

}

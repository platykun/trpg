package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.belonging.BelongingListFactory;
import com.trpg.domain.model.character.parameter.ParameterList;
import com.trpg.domain.model.character.parameter.ParameterListFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HumanFactory {

    @Autowired
    ParameterListFactory parameterListFactory;
    @Autowired
    BelongingListFactory belongingListFactory;

    public Human create(int humanId, int characterId, String name, ParameterList parameterList, BelongingList belongingList, Job job, String school,
            String comeFrom, String mentalDisorder, String sex, int age, HumanType type, DetailList detailList) {
        Human human = new Human(humanId, characterId, name, parameterList, belongingList, job, school, comeFrom, mentalDisorder, sex, age, type, detailList);
        return human;
    }

    public Human createInit(){
        ParameterList parameterList = parameterListFactory.createInitialParameter();
        BelongingList belongingList = belongingListFactory.createInitialBelonging();
        DetailList detailList = new DetailList();
        Human human = create(0, 0, "", parameterList, belongingList, null, "", "", "", "", 0, HumanType.SEARCHER, detailList);
        return human;
    }
}

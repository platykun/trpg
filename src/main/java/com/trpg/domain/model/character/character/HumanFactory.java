package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;
import org.springframework.stereotype.Repository;

@Repository
public class HumanFactory {
    public Human create(String name, ParameterList parameterList, BelongingList belongingList, Job job, String school,
            String comeFrom, String mentalDisorder, String sex, int age, HumanType type, DetailList detailList) {
        Human human = new Human(name, parameterList, belongingList, job, school, comeFrom, mentalDisorder, sex, age, type, detailList);
        return human;
    }
}

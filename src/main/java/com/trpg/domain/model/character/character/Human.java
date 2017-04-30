package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;

public class Human extends Character {
    /** 職業 */
    private Job job;
    /** 学校・学位 */
    private String school;
    /** 出身 */
    private String comeFrom;
    /** 精神的な障害 */
    private String mentalDisorder;
    /** 性別 */
    private String sex;
    /** 年齢 */
    private int age;
    /** 種別 */
    private HumanType type;
    /** 詳細 */
    private DetailList detailList;

    Human(String name, ParameterList parameterList, BelongingList belongingList, Job job, String school,
            String comeFrom, String mentalDisorder, String sex, int age, HumanType type, DetailList detailList) {
        super(name, parameterList, belongingList);
        this.job = job;
        this.school = school;
        this.comeFrom = comeFrom;
        this.mentalDisorder = mentalDisorder;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.detailList = detailList;
    }
}

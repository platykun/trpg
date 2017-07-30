package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;
import lombok.Getter;

/**
 * 人間ドメインオブジェクト。探索者、NPCを含む。
 */
public class Human extends Character {
    /** 人間ID */
    @Getter
    private int humanId;
    /** 職業 */
    @Getter
    private Job job;
    /** 学校・学位 */
    @Getter
    private String school;
    /** 出身 */
    @Getter
    private String comeFrom;
    /** 精神的な障害 */
    @Getter
    private String mentalDisorder;
    /** 性別 */
    @Getter
    private String sex;
    /** 年齢 */
    @Getter
    private int age;
    /** 種別 */
    @Getter
    private HumanType type;
    /** 詳細 */
    @Getter
    private DetailList detailList;

    Human(int humanId,int characterId, String name, ParameterList parameterList, BelongingList belongingList, Job job, String school,
            String comeFrom, String mentalDisorder, String sex, int age, HumanType type, DetailList detailList) {
        super(characterId, name, parameterList, belongingList);
        this.humanId = humanId;
        this.job = job;
        this.school = school;
        this.comeFrom = comeFrom;
        this.mentalDisorder = mentalDisorder;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.detailList = detailList;
    }

    /**
     * 職業IDを取得する。職業が存在しない場合は-1を返却する。
     *
     * @return 職業ID
     */
    public int getJobId(){
        if(job != null){
            return job.getId();
        }
        return 0;
    }
}

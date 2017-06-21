package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.belonging.BelongingListFactory;
import com.trpg.domain.model.character.parameter.ParameterList;
import com.trpg.domain.model.character.parameter.ParameterListFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 人間ドメインを作成するファクトリクラス。
 */
@Repository
public class HumanFactory {

    /** パラメータリストのファクトリオブジェクト。 */
    @Autowired
    ParameterListFactory parameterListFactory;
    /** 所持品リストのファクトリオブジェクト。 */
    @Autowired
    BelongingListFactory belongingListFactory;

    /**
     * 人間オブジェクトを作成する。
     *
     * @param humanId 人間ID
     * @param characterId キャラクタID
     * @param name 名前
     * @param parameterList パラメータリスト
     * @param belongingList 所持品リスト
     * @param job 職業
     * @param school 学校
     * @param comeFrom 出身地
     * @param mentalDisorder 精神的な障害
     * @param sex 性別
     * @param age 年齢
     * @param type 人間種別
     * @param detailList 詳細リスト
     * @return 人間オブジェクト
     */
    public Human create(int humanId, int characterId, String name, ParameterList parameterList, BelongingList belongingList, Job job, String school,
            String comeFrom, String mentalDisorder, String sex, int age, HumanType type, DetailList detailList) {
        Human human = new Human(humanId, characterId, name, parameterList, belongingList, job, school, comeFrom, mentalDisorder, sex, age, type, detailList);
        return human;
    }

    /**
     * 初期値の人間オブジェクトを作成する。
     *
     * @return 初期値の人間オブジェクト。
     */
    public Human createInit(){
        ParameterList parameterList = parameterListFactory.createInitialParameter();
        BelongingList belongingList = belongingListFactory.createInitialBelonging();
        DetailList detailList = new DetailList();
        Human human = create(0, 0, "", parameterList, belongingList, null, "", "", "", "", 0, HumanType.SEARCHER, detailList);
        return human;
    }
}

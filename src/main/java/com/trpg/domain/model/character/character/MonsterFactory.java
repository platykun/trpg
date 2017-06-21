package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;

/**
 * モンスターを作成するファクトリクラス。
 */
public class MonsterFactory{
    /**
     * モンスターを作成する。
     *
     * @param monsterId モンスターID
     * @param characterId キャラクターID
     * @param name 名前
     * @param parameterList パラメータリスト
     * @param belongingList 所持品リスト
     * @param armor 装甲
     * @param lackOfSanity 正気度喪失
     * @param remarks 備考
     * @return モンスターオブジェクト
     */
    public Monster create(int monsterId, int characterId, String name, ParameterList parameterList, BelongingList belongingList, int armor,
            String lackOfSanity, String remarks) {
        Monster monster = new Monster(monsterId, characterId, name, parameterList, belongingList, armor, lackOfSanity, remarks);
        return monster;
    }
}

package com.trpg.form.character;

import com.trpg.form.character.common.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * キャラクターを作成するための初期値を格納する。
 * 
 * @author platykun
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterAddForm {

    /** キャラクターID */
    private int id;

    /** 名前 */
    private String name;

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
    private int humanType;

    /** 能力値及び能力ロール */
    private List<ParameterForm> avilityList;

    /** ステータス */
    private List<ParameterForm> statusList;

    /** 職業 */
    private List<JobForm> jobList;

    /** 探索者の技能 */
    private List<ParameterForm> skillList;

    /** 所持品 */
    private List<BelongingForm> belongingList;

    /** 詳細情報 */
    private List<DetailForm> detailList;

}
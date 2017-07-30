package com.trpg.form.character;

import com.trpg.form.character.common.BelongingForm;
import com.trpg.form.character.common.DetailForm;
import com.trpg.form.character.common.JobForm;
import com.trpg.form.character.common.ParameterForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * キャラクターを更新するための値を格納する。
 * 
 * @author platykun
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterUpdateForm {

    /** キャラクターID */
    private int characterId;

    /** HumanID */
    private int HumanId;

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
    private List<ParameterForm> abilityList;

    /** ステータス */
    private List<ParameterForm> statusList;

    /** 所属職業ID */
    private int jobId;

    /** 所属職業名 */
    private String jobName;

    /** 職業 */
    private List<JobForm> jobList;

    /** 探索者の技能 */
    private List<ParameterForm> skillList;

    /** 所持品 */
    private List<BelongingForm> belongingList;

    /** 詳細情報 */
    private List<DetailForm> detailList;

}

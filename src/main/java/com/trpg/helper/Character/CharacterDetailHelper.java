package com.trpg.helper.Character;

import com.trpg.domain.model.character.belonging.*;
import com.trpg.domain.model.character.character.*;
import com.trpg.domain.model.character.parameter.*;
import com.trpg.form.character.CharacterDetailForm;
import com.trpg.form.character.common.BelongingForm;
import com.trpg.form.character.common.DetailForm;
import com.trpg.form.character.common.JobForm;
import com.trpg.form.character.common.ParameterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * キャラクタのFormとDomainを変換する。
 */
@Controller
public class CharacterDetailHelper {

    @Autowired
    ParameterListFactory parameterListFactory;

    @Autowired
    BelongingListFactory belongingListFactory;

    @Autowired
    CharacterCommonHelper commonHelper;

    /**
     * HumanドメインからCreateDetailFormを作成する。
     *
     * @param human Humanドメイン
     * @return CreateDetailForm
     */
    public CharacterDetailForm convertToDetailForm(Human human) {
        CharacterDetailForm form = new CharacterDetailForm();
        form.setId(human.getCharacterId());
        form.setName(human.getName());
        form.setComeFrom(human.getComeFrom());
        form.setMentalDisorder(human.getMentalDisorder());
        form.setSex(human.getSex());
        form.setAge(human.getAge());
        form.setHumanType(human.getType().getId());

        ParameterList parameterList = human.getParameterList();

        //能力値のパラメータを設定。
        List<Parameter> avilityList = parameterList.getCharactristicsParameterList();
        List<ParameterForm> avilityListForm = new ArrayList<>();
        avilityList.stream().forEach(e -> avilityListForm.add(commonHelper.convertToParameterForm(e)));
        form.setAbilityList(avilityListForm);

        //ステータスのパラメータを設定
        List<Parameter> statusList = parameterList.getStatusList();
        List<ParameterForm> statusListForm = new ArrayList<>();
        statusList.stream().forEach(e -> statusListForm.add(commonHelper.convertToParameterForm(e)));
        form.setStatusList(statusListForm);

        //技能のパラメータを設定。
        List<Parameter> skillList = parameterList.getInvestigatorSkillList();
        List<ParameterForm> skillListForm = new ArrayList<>();
        skillList.stream().forEach(e -> skillListForm.add(commonHelper.convertToParameterForm(e)));
        form.setSkillList(skillListForm);

        // characterの職業情報を格納する。
        Job job = human.getJob();
        form.setJobId(job.getId());
        form.setJobName(job.getName());

        //BelongingList
        BelongingList belongings = human.getBelongingList();
        List<BelongingForm> belongingFormList = new ArrayList<>();
        belongings.getBelongings().stream().forEach(b -> belongingFormList.add(commonHelper.convertToBelongingForm(b)));
        form.setBelongingList(belongingFormList);

        //DetailList

        return form;
    }

    /**
     * CreateFormから探索者オブジェクトを作成する。
     *
     * @param characterDetailForm characterDetailForm
     * @return 探索者オブジェクト
     */
    public Human convertToHuman(CharacterDetailForm characterDetailForm){
        // 所持品オブジェクトを作成する。
        BelongingList belongingList = belongingListFactory.create();
        List<BelongingForm> belongingListForm = characterDetailForm.getBelongingList();
        belongingListForm.stream().forEach(b -> belongingList.add(commonHelper.convertFormToBelonging(b)));

        // 詳細オブジェクトを作成する
        DetailList detailList = new DetailList();
        List<DetailForm> detailValueList = characterDetailForm.getDetailList();
        detailValueList.stream().forEach(d -> detailList.add(commonHelper.convertToDetail(d)));

        //パラメータオブジェクトを作成する
        ParameterList parameterList = parameterListFactory.create();
        List<ParameterForm> parameterValueList = new ArrayList<>();
        //能力値のパラメータオブジェクトを作成。
        parameterValueList.addAll(characterDetailForm.getAbilityList());
        //ステータスのパラメータオブジェクトを作成。
        parameterValueList.addAll(characterDetailForm.getStatusList());
        //技能のパラメータオブジェクトを作成。
        parameterValueList.addAll(characterDetailForm.getSkillList());
        parameterValueList.stream().forEach(p -> parameterList.add(commonHelper.convertToParameter(p)));

        //基礎ステータスを取得する

        //探索者オブジェクトを作成する。

        return null;
    }
}

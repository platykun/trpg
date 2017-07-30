package com.trpg.helper.Character;

import com.trpg.domain.model.character.belonging.*;
import com.trpg.domain.model.character.character.*;
import com.trpg.domain.model.character.parameter.*;
import com.trpg.form.character.CharacterUpdateForm;
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
public class CharacterUpdateHelper {

    @Autowired
    HumanFactory humanFactory;

    @Autowired
    ParameterListFactory parameterListFactory;

    @Autowired
    BelongingListFactory belongingListFactory;

    @Autowired
    CharacterCommonHelper commonHelper;

    /**
     * HumanドメインからCharacterEditFormを作成する。
     *
     * @param human Humanドメイン
     * @param jobList 職業リスト
     * @return CharacterUpdateForm
     */
    public CharacterUpdateForm convertToUpdateForm(Human human, JobList jobList) {
        CharacterUpdateForm form = new CharacterUpdateForm();
        form.setCharacterId(human.getCharacterId());
        form.setHumanId(human.getHumanId());
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
        avilityList.forEach(e -> avilityListForm.add(commonHelper.convertToParameterForm(e)));
        form.setAbilityList(avilityListForm);

        //ステータスのパラメータを設定
        List<Parameter> statusList = parameterList.getStatusList();
        List<ParameterForm> statusListForm = new ArrayList<>();
        statusList.forEach(e -> statusListForm.add(commonHelper.convertToParameterForm(e)));
        form.setStatusList(statusListForm);

        //技能のパラメータを設定。
        List<Parameter> skillList = parameterList.getInvestigatorSkillList();
        List<ParameterForm> skillListForm = new ArrayList<>();
        skillList.forEach(e -> skillListForm.add(commonHelper.convertToParameterForm(e)));
        //武器のパラメータを設定
        List<Parameter> weaponSkillList = parameterList.getWeaponSkillList();
        //List<ParameterForm> weaponSkillListForm = new ArrayList<>();
        weaponSkillList.forEach(e -> skillListForm.add(commonHelper.convertToParameterForm(e)));

        form.setSkillList(skillListForm);

        //JobList
        List<JobForm> jobFormList = new ArrayList<JobForm>();
        jobList.getJobList().forEach(j -> jobFormList.add(commonHelper.convertToJobForm(j)));
        form.setJobList(jobFormList);


        //BelongingList
        BelongingList belongingList = human.getBelongingList();
        List<BelongingForm> belongingFormList = new ArrayList<>();
        belongingList.getBelongings().forEach(b -> belongingFormList.add(commonHelper.convertToBelongingForm(b)));
        form.setBelongingList(belongingFormList);

        //DetailList
        DetailList detailList = human.getDetailList();
        List<DetailForm> detailFormList = new ArrayList<>();
        detailList.getDetailList().forEach(d -> detailFormList.add(commonHelper.convertToDetailForm(d)));
        form.setDetailList(detailFormList);

        return form;
    }

    /**
     * CreateFormから探索者オブジェクトを作成する。</br>
     * JobDetailは作成しない。必要な場合はDBから取得すること。
     *
     * @param characterUpdateForm characterUpdateForm
     * @return 探索者オブジェクト
     */
    public Human convertToHuman(CharacterUpdateForm characterUpdateForm){
        // 所持品オブジェクトを作成する。
        BelongingList belongingList = belongingListFactory.create();
        List<BelongingForm> belongingListForm = characterUpdateForm.getBelongingList();
        if(belongingListForm != null) {
            belongingListForm.forEach(b -> belongingList.add(commonHelper.convertFormToBelonging(b)));
        }

        // 詳細オブジェクトを作成する
        DetailList detailList = new DetailList();
        List<DetailForm> detailValueList = characterUpdateForm.getDetailList();
        if(detailValueList != null) {
            detailValueList.forEach(d -> detailList.add(commonHelper.convertToDetail(d)));
        }

        //パラメータオブジェクトを作成する
        ParameterList parameterList = parameterListFactory.create();
        List<ParameterForm> parameterValueList = new ArrayList<>();
        //能力値のパラメータオブジェクトを作成。
        List<ParameterForm> avilityList = characterUpdateForm.getAbilityList();
        if(avilityList != null){
            parameterValueList.addAll(avilityList);
        }
        //ステータスのパラメータオブジェクトを作成。
        List<ParameterForm> statusList = characterUpdateForm.getStatusList();
        if(statusList != null){
            parameterValueList.addAll(statusList);
        }
        //技能のパラメータオブジェクトを作成。
        List<ParameterForm> skillList = characterUpdateForm.getSkillList();
        if(skillList != null){
            parameterValueList.addAll(characterUpdateForm.getSkillList());
        }

        parameterValueList.forEach(p -> parameterList.add(commonHelper.convertToParameter(p)));

        //基礎ステータスを取得する

        //探索者オブジェクトを作成する。

        int humanId = characterUpdateForm.getHumanId();
        int characterId = characterUpdateForm.getCharacterId();
        String name = characterUpdateForm.getName();

        int jobId = characterUpdateForm.getJobId();
        String jobName = characterUpdateForm.getJobName();
        //ジョブ詳細は作成していない。必要な場合はDBから取得する。
        List<InvestigatorSkillType> jobSkillList = null;
        Job job = new Job(jobId, jobName, jobSkillList);

        String school = characterUpdateForm.getSchool();
        String comeFrom = characterUpdateForm.getComeFrom();
        String mentalDisorder = characterUpdateForm.getMentalDisorder();
        String sex = characterUpdateForm.getSex();
        int age = characterUpdateForm.getAge();
        HumanType humanType = HumanType.getType(characterUpdateForm.getHumanType());
        Human human = humanFactory.create(humanId, characterId, name, parameterList, belongingList, job, school, comeFrom, mentalDisorder, sex, age, humanType, detailList);

        return human;
    }

    public Job convertToJob(CharacterUpdateForm characterUpdateForm){
        int id = characterUpdateForm.getJobId();
        String name = characterUpdateForm.getJobName();
        List<JobForm> jobFormList = characterUpdateForm.getJobList();

        List<InvestigatorSkillType> skillList = new ArrayList<>();
        jobFormList.forEach(j -> skillList.add(InvestigatorSkillType.getType(j.getId())));

        Job job = new Job(id, name, skillList);
        return job;
    }
}

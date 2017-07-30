package com.trpg.helper.Character;

import com.trpg.domain.model.character.belonging.*;
import com.trpg.domain.model.character.character.*;
import com.trpg.domain.model.character.parameter.*;
import com.trpg.form.character.*;
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
public class CharacterCreateHelper {

    @Autowired
    HumanFactory humanFactory;

    @Autowired
    ParameterListFactory parameterListFactory;

    @Autowired
    BelongingListFactory belongingListFactory;

    @Autowired
    CharacterCommonHelper commonHelper;


    /**
     * HumanドメインからCreateFormを作成する。
     *
     * @param human
     * @param jobList
     * @return
     */
    public CharacterAddForm convertToCreateForm(Human human, JobList jobList) {
        CharacterAddForm form = new CharacterAddForm();
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
        //武器のパラメータを設定
        List<Parameter> weaponSkillList = parameterList.getWeaponSkillList();
        //List<ParameterForm> weaponSkillListForm = new ArrayList<>();
        weaponSkillList.stream().forEach(e -> skillListForm.add(commonHelper.convertToParameterForm(e)));

        form.setSkillList(skillListForm);

        //JobList
        List<JobForm> jobFormList = new ArrayList<JobForm>();
        jobList.getJobList().stream().forEach(j -> jobFormList.add(commonHelper.convertToJobForm(j)));
        form.setJobList(jobFormList);


        //BelongingList
        BelongingList belongingList = human.getBelongingList();
        List<BelongingForm> belongingFormList = new ArrayList<>();
        belongingList.getBelongings().stream().forEach(b -> belongingFormList.add(commonHelper.convertToBelongingForm(b)));
        form.setBelongingList(belongingFormList);

        //DetailList
        DetailList detailList = human.getDetailList();
        List<DetailForm> detailFormList = new ArrayList<>();
        detailList.getDetailList().stream().forEach(d -> detailFormList.add(commonHelper.convertToDetailForm(d)));
        form.setDetailList(detailFormList);


        return form;
    }

    /**
     * CreateFormから探索者オブジェクトを作成する。</br>
     * JobDetailは作成しない。必要な場合はDBから取得すること。
     *
     * @param characterAddForm characterAddForm
     * @return 探索者オブジェクト
     */
    public Human convertToHuman(CharacterAddForm characterAddForm){
        // 所持品オブジェクトを作成する。
        BelongingList belongingList = belongingListFactory.create();
        List<BelongingForm> belongingListForm = characterAddForm.getBelongingList();
        if(belongingListForm != null) {
            belongingListForm.stream().forEach(b -> belongingList.add(commonHelper.convertFormToBelonging(b)));
        }

        // 詳細オブジェクトを作成する
        DetailList detailList = new DetailList();
        List<DetailForm> detailValueList = characterAddForm.getDetailList();
        if(detailValueList != null) {
            detailValueList.stream().forEach(d -> detailList.add(commonHelper.convertToDetail(d)));
        }

        //パラメータオブジェクトを作成する
        ParameterList parameterList = parameterListFactory.create();
        List<ParameterForm> parameterValueList = new ArrayList<>();
        //能力値のパラメータオブジェクトを作成。
        List<ParameterForm> avilityList = characterAddForm.getAbilityList();
        if(avilityList != null){
            parameterValueList.addAll(avilityList);
        }
        //ステータスのパラメータオブジェクトを作成。
        List<ParameterForm> statusList = characterAddForm.getStatusList();
        if(statusList != null){
            parameterValueList.addAll(statusList);
        }
        //技能のパラメータオブジェクトを作成。
        List<ParameterForm> skillList = characterAddForm.getSkillList();
        if(skillList != null){
            parameterValueList.addAll(characterAddForm.getSkillList());
        }

        parameterValueList.stream().forEach(p -> parameterList.add(commonHelper.convertToParameter(p)));

        //基礎ステータスを取得する

        //探索者オブジェクトを作成する。

        int humanId = 0; //TODO: humanIDもformで渡すべき
        int characterId = characterAddForm.getId();
        String name = characterAddForm.getName();

        int jobId = characterAddForm.getJobId();
        String jobName = characterAddForm.getJobName();
        //ジョブ詳細は作成していない。必要な場合はDBから取得する。
        List<InvestigatorSkillType> jobSkillList = null;
        Job job = new Job(jobId, jobName, jobSkillList);

        String school = characterAddForm.getSchool();
        String comeFrom = characterAddForm.getComeFrom();
        String mentalDisorder = characterAddForm.getMentalDisorder();
        String sex = characterAddForm.getSex();
        int age = characterAddForm.getAge();
        HumanType humanType = HumanType.getType(characterAddForm.getHumanType());
        Human human = humanFactory.create(humanId, characterId, name, parameterList, belongingList, job, school, comeFrom, mentalDisorder, sex, age, humanType, detailList);

        return human;
    }

    public Job convertToJob(CharacterAddForm characterAddForm){
        int id = characterAddForm.getJobId();
        String name = characterAddForm.getJobName();
        List<JobForm> jobFormList = characterAddForm.getJobList();

        List<InvestigatorSkillType> skillList = new ArrayList<>();
        jobFormList.stream().forEach(j -> skillList.add(InvestigatorSkillType.getType(j.getId())));

        Job job = new Job(id, name, skillList);
        return job;
    }
}

package com.trpg.helper;

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
    ParameterFactory parameterFactory;

    @Autowired
    BelongingListFactory belongingListFactory;

    @Autowired
    BelongingFactory belongigFactory;


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
        avilityList.forEach(e -> avilityListForm.add(convertToParameterForm(e)));
        form.setAbilityList(avilityListForm);

        //ステータスのパラメータを設定
        List<Parameter> statusList = parameterList.getStatusList();
        List<ParameterForm> statusListForm = new ArrayList<>();
        statusList.forEach(e -> statusListForm.add(convertToParameterForm(e)));
        form.setStatusList(statusListForm);

        //技能のパラメータを設定。
        List<Parameter> skillList = parameterList.getInvestigatorSkillList();
        List<ParameterForm> skillListForm = new ArrayList<>();
        skillList.forEach(e -> skillListForm.add(convertToParameterForm(e)));
        //武器のパラメータを設定
        List<Parameter> weaponSkillList = parameterList.getWeaponSkillList();
        //List<ParameterForm> weaponSkillListForm = new ArrayList<>();
        weaponSkillList.forEach(e -> skillListForm.add(convertToParameterForm(e)));

        form.setSkillList(skillListForm);

        //JobList
        List<JobForm> jobFormList = new ArrayList<JobForm>();
        jobList.getJobList().forEach(j -> jobFormList.add(convertToJobForm(j)));
        form.setJobList(jobFormList);


        //BelongingList
        BelongingList belongingList = human.getBelongingList();
        List<BelongingForm> belongingFormList = new ArrayList<>();
        belongingList.getBelongings().forEach(b -> belongingFormList.add(convertToBelongingForm(b)));
        form.setBelongingList(belongingFormList);

        //DetailList
        DetailList detailList = human.getDetailList();
        List<DetailForm> detailFormList = new ArrayList<>();
        detailList.getDetailList().forEach(d -> detailFormList.add(convertToDetailForm(d)));
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
            belongingListForm.forEach(b -> belongingList.add(convertFormToBelonging(b)));
        }

        // 詳細オブジェクトを作成する
        DetailList detailList = new DetailList();
        List<DetailForm> detailValueList = characterUpdateForm.getDetailList();
        if(detailValueList != null) {
            detailValueList.forEach(d -> detailList.add(convertToDetail(d)));
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

        parameterValueList.forEach(p -> parameterList.add(convertToParameter(p)));

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

    /**
     * パラメータオブジェクトからパラメータフォームへ変換する。
     *
     * @param parameter パラメータオブジェクト
     * @return パラメータ
     */
    private ParameterForm convertToParameterForm(Parameter parameter){
        ParameterForm parameterForm = new ParameterForm();
        ParameterType parameterType = parameter.getParameterType();

        parameterForm.setParamId(parameterType.getId());
        parameterForm.setParamSubId(parameter.getSubParameterTypeValue());
        parameterForm.setValue(parameter.getParameter());
        parameterForm.setStringValue(parameter.getDiceParameter());
        parameterForm.setName(parameter.getParameterPatternName());
        parameterForm.setInitValue(parameterType.getInitValue());

        return parameterForm;
    }

    /**
     * ジョブオブジェクトからJobFormへ変換する。
     *
     * @param job 職業オブジェクト
     * @return JobForm
     */
    private JobForm convertToJobForm(Job job){
        JobForm jobForm = new JobForm();
        jobForm.setId(job.getId());
        jobForm.setName(job.getName());
        List<Integer> skillList = new ArrayList<Integer>();
        List<InvestigatorSkillType> investigatorSkillTypeList = job.getSkillList();
        investigatorSkillTypeList.forEach(i -> skillList.add(i.getId()));
        jobForm.setSkillList(skillList);

        return jobForm;
    }

    /**
     * 所持品オブジェクトから所持品フォームを作成する。
     *
     * @param belonging 所持品オブジェクト
     * @return 所持品フォーム
     */
    private BelongingForm convertToBelongingForm(Belonging belonging){
        int typeId = belonging.getType().getId();
        String name = belonging.getName();
        String description = belonging.getDescription();
        BelongingForm belongingForm = new BelongingForm(typeId, name, description);
        return belongingForm;
    }

    /**
     * 所持品フォームから所持品オブジェクトを作成する。
     *
     * @param belongingForm 所持品フォーム
     * @return 所持品オブジェクト
     */
    private Belonging convertFormToBelonging(BelongingForm belongingForm){
        BelongingType belongingType = BelongingType.getType(belongingForm.getTypeId());
        String name = belongingForm.getName();
        Belonging belonging = belongigFactory.createBelonging(0, belongingType, name, "");
        return belonging;
    }

    /**
     * パラメータオブジェクトを作成する。
     *
     * @param parameterForm パラメータフォーム
     * @return パラメータオブジェクト
     */
    private Parameter convertToParameter(ParameterForm parameterForm){
        //TODO: CharacterDetailHelperと重複コードになってるため修正する
        ParameterType parameterType = ParameterType.getType(parameterForm.getParamId());

        //int id = parameterForm.getParamId();
        //TODO: idを引数で渡すようにするか別の方法を検討する。
        int id = 0;
        int param = parameterForm.getValue();
        int defaultValue = parameterForm.getInitValue();
        int subId = parameterForm.getParamSubId();

        Parameter parameter = null;
        switch(parameterType){
            case CHARACTERISTICS:
                CharactristicsType charactristicsType = CharactristicsType.getType(subId);
                parameter = parameterFactory.createCharacteristics(id, param, defaultValue, charactristicsType);
                break;
            case SANITY_POINTS:
                parameter = parameterFactory.createSanityPoints(id, param, defaultValue);
                break;
            case MAGIC_POINTS:
                parameter = parameterFactory.createMagicPoints(id, param, defaultValue);
                break;
            case HIT_POINTS:
                parameter = parameterFactory.createHitPoints(id, param, defaultValue);
                break;
            case INVESTIGATOR_SKILLS:
                InvestigatorSkillType investigatorSkillType = InvestigatorSkillType.getType(subId);
                parameter = parameterFactory.createInvestigatorSkill(id, param, defaultValue, investigatorSkillType);
                break;
            case WEAPONS:
                WeaponType weaponType = WeaponType.getType(subId);
                parameter = parameterFactory.createWeapon(id, param, defaultValue, weaponType);
                break;
        }
        return parameter;
    }

    /**
     * 詳細オブジェクトを作成する。
     *
     * @param detailForm 詳細フォーム
     * @return 詳細オブジェクト
     */
    private Detail convertToDetail(DetailForm detailForm){
        int id = detailForm.getParamId();
        DetailType type = DetailType.getType(detailForm.getParamSubId());
        String detail = detailForm.getStringValue();
        Detail detailObj = new Detail(id, type, detail);
        return detailObj;
    }


    private DetailForm convertToDetailForm(Detail detail){
        int paramId = detail.getId();
        int paramSubId = 0;//不要論
        int value = 0;
        String stringValue = "";
        String name = detail.getDetail();
        int initValue = 0;

        DetailForm detailForm = new DetailForm(paramId, paramSubId, value, stringValue, name, initValue);
        return detailForm;
    }


}

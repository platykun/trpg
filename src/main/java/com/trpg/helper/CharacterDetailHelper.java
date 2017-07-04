package com.trpg.helper;

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
    ParameterFactory parameterFactory;

    @Autowired
    BelongingListFactory belongingListFactory;

    @Autowired
    BelongingFactory belongigFactory;


    /**
     * HumanドメインからCreateDetailFormを作成する。
     *
     * @param human Humanドメイン
     * @param jobList 職業リスト
     * @return CreateDetailForm
     */
    public CharacterDetailForm convertToDetailForm(Human human, JobList jobList) {
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
        avilityList.stream().forEach(e -> avilityListForm.add(convertToParameterForm(e)));
        form.setAvilityList(avilityListForm);

        //ステータスのパラメータを設定
        List<Parameter> statusList = parameterList.getStatusList();
        List<ParameterForm> statusListForm = new ArrayList<>();
        statusList.stream().forEach(e -> statusListForm.add(convertToParameterForm(e)));
        form.setStatusList(statusListForm);

        //技能のパラメータを設定。
        List<Parameter> skillList = parameterList.getInvestigatorSkillList();
        List<ParameterForm> skillListForm = new ArrayList<>();
        skillList.stream().forEach(e -> skillListForm.add(convertToParameterForm(e)));
        form.setSkillList(skillListForm);

        //JobList
        List<JobForm> jobFormList = new ArrayList<JobForm>();
        jobList.getJobList().stream().forEach(j -> jobFormList.add(convertToJobForm(j)));
        form.setJobList(jobFormList);


        //BelongingList


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
        belongingListForm.stream().forEach(b -> belongingList.add(convertFormToBelonging(b)));

        // 詳細オブジェクトを作成する
        DetailList detailList = new DetailList();
        List<DetailForm> detailValueList = characterDetailForm.getDetailList();
        detailValueList.stream().forEach(d -> detailList.add(convertToDetail(d)));

        //パラメータオブジェクトを作成する
        ParameterList parameterList = parameterListFactory.create();
        List<ParameterForm> parameterValueList = new ArrayList<>();
        //能力値のパラメータオブジェクトを作成。
        parameterValueList.addAll(characterDetailForm.getAvilityList());
        //ステータスのパラメータオブジェクトを作成。
        parameterValueList.addAll(characterDetailForm.getStatusList());
        //技能のパラメータオブジェクトを作成。
        parameterValueList.addAll(characterDetailForm.getSkillList());
        parameterValueList.stream().forEach(p -> parameterList.add(convertToParameter(p)));

        //基礎ステータスを取得する

        //探索者オブジェクトを作成する。

        return null;
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
        investigatorSkillTypeList.stream().forEach(i -> skillList.add(i.getId()));
        jobForm.setSkillList(skillList);

        return jobForm;
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
        ParameterType parameterType = ParameterType.getType(parameterForm.getParamId());
        int param = parameterForm.getValue();
        int defaultValue = parameterForm.getInitValue();
        int subId = parameterForm.getParamSubId();

        Parameter parameter = null;
        switch(parameterType){
            case CHARACTERISTICS:
                CharactristicsType charactristicsType = CharactristicsType.getType(subId);
                parameter = parameterFactory.createCharacteristics(0, param, defaultValue, charactristicsType);
                break;
            case SANITY_POINTS:
                break;
            case MAGIC_POINTS:
                break;
            case HIT_POINTS:
                break;
            case INVESTIGATOR_SKILLS:
                break;
                // TODO: 残りも作り込んでいく。
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



}

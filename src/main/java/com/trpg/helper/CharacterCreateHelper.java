package com.trpg.helper;

import com.trpg.domain.model.character.belonging.*;
import com.trpg.domain.model.character.character.*;
import com.trpg.domain.model.character.parameter.*;
import com.trpg.form.character.*;
import com.trpg.service.BelongingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.criteria.CriteriaBuilder;
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
    ParameterFactory parameterFactory;

    @Autowired
    BelongingListFactory belongingListFactory;

    @Autowired
    BelongingFactory belongigFactory;


    /**
     * HumanドメインからCreaeFormを作成する。
     *
     * @param human
     * @param jobList
     * @return
     */
    public CreateForm convertToCreateForm(Human human, JobList jobList) {
        CreateForm form = new CreateForm();
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
        List<ValueForm> avilityListForm = new ArrayList<ValueForm>();
        avilityList.stream().forEach(e -> avilityListForm.add(convertParameterToValueForm(e)));
        form.setAvilityList(avilityListForm);

        //ステータスのパラメータを設定
        List<Parameter> statusList = parameterList.getStatusList();
        List<ValueForm> statusListForm = new ArrayList<ValueForm>();
        statusList.stream().forEach(e -> statusListForm.add(convertParameterToValueForm(e)));
        form.setStatusList(statusListForm);

        //技能のパラメータを設定。
        List<Parameter> skillList = parameterList.getInvestigatorSkillList();
        List<ValueForm> skillListForm = new ArrayList<ValueForm>();
        skillList.stream().forEach(e -> skillListForm.add(convertParameterToValueForm(e)));
        form.setSkillList(skillListForm);

        //JobList
        List<JobForm> jobFormList = new ArrayList<JobForm>();
        jobList.getJobList().stream().forEach(j -> jobFormList.add(convertJobToJobForm(j)));
        form.setJobList(jobFormList);


        //BelongingList


        //DetailList

        return form;
    }

    public Human convertToHuman(CreateForm createForm){
        // 所持品オブジェクトを作成する。
        BelongingList belongingList = belongingListFactory.create();
        List<ValueForm> belongingListForm = createForm.getBelongingList();
        belongingListForm.stream().forEach(b -> belongingList.add(convertValueFormToBelonging(b)));

        //

        return null;
    }

    private ValueForm convertParameterToValueForm(Parameter parameter){
        ValueForm valueForm = new ValueForm();
        ParameterType parameterType = parameter.getParameterType();

        valueForm.setParamId(parameterType.getId());
        valueForm.setParamSubId(parameter.getSubParameterTypeValue());
        valueForm.setValue(parameter.getParameter());
        valueForm.setStringValue(parameter.getDiceParameter());
        valueForm.setName(parameter.getParameterPatternName());
        valueForm.setInitValue(parameterType.getInitValue());

        return valueForm;
    }

    private JobForm convertJobToJobForm(Job job){
        JobForm jobForm = new JobForm();
        jobForm.setId(job.getId());
        jobForm.setName(job.getName());
        List<Integer> skillList = new ArrayList<Integer>();
        List<InvestigatorSkillType> investigatorSkillTypeList = job.getSkillList();
        investigatorSkillTypeList.stream().forEach(i -> skillList.add(i.getId()));
        jobForm.setSkillList(skillList);

        return jobForm;
    }

    private Belonging convertValueFormToBelonging(ValueForm valueForm){
        BelongingType belongingType = BelongingType.getType(valueForm.getParamId());
        String name = valueForm.getName();
        Belonging belonging = belongigFactory.createBelonging(0, belongingType, name, "");
        return belonging;
    }

    private Parameter convertToParameter(ValueForm valueForm){
        ParameterType parameterType = ParameterType.getType(valueForm.getParamId());
        int param = valueForm.getValue();
        int defaultValue = valueForm.getInitValue();
        int subId = valueForm.getParamSubId();

        Parameter parameter = null;
        switch(parameterType){
            case CHARACTERISTICS:
                CharactristicsType charactristicsType = CharactristicsType.getType(subId);
                parameter = parameterFactory.createCharacteristics(0, param, defaultValue, charactristicsType);
            // TODO: 残りも作り込んでいく。
        }
        return parameter;
    }
}

package com.trpg.helper;

import com.trpg.domain.model.character.character.Human;
import com.trpg.domain.model.character.character.HumanList;
import com.trpg.domain.model.character.character.Job;
import com.trpg.domain.model.character.character.JobList;
import com.trpg.domain.model.character.parameter.*;
import com.trpg.form.character.*;
import org.springframework.stereotype.Controller;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CharacterCreateHelper {
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

        List<Parameter> avilityList = parameterList.getCharactristicsParameterList();
        List<ValueForm> avilityListForm = new ArrayList<ValueForm>();
        avilityList.stream().forEach(e -> avilityListForm.add(convertParameterToValueForm(e)));
        form.setAvilityList(avilityListForm);

        List<Parameter> statusList = parameterList.getStatusList();
        List<ValueForm> statusListForm = new ArrayList<ValueForm>();
        statusList.stream().forEach(e -> statusListForm.add(convertParameterToValueForm(e)));
        form.setStatusList(statusListForm);

        //JobList
        List<JobForm> jobFormList = new ArrayList<JobForm>();
        jobList.getJobList().stream().forEach(j -> jobFormList.add(convertJobToJobForm(j)));
        form.setJobList(jobFormList);

        //SkillList
        List<Parameter> skillList = parameterList.getInvestigatorSkillList();
        List<ValueForm> skillListForm = new ArrayList<ValueForm>();
        skillList.stream().forEach(e -> skillListForm.add(convertParameterToValueForm(e)));
        form.setStatusList(skillListForm);

        //BelongingList

        //DetailList

        return form;
    }

    private ValueForm convertParameterToValueForm(Parameter parameter){
        ValueForm valueForm = new ValueForm();
        ParameterPattern parameterPattern = parameter.getParameterPattern();
        ParameterType parameterType = parameterPattern.getParameterType();

        valueForm.setParamId(parameterType.getId());
        valueForm.setParamSubId(parameterPattern.getSubParameterTypeValue());
        valueForm.setValue(parameter.getParameter());
        valueForm.setStringValue(parameter.getDiceParameter());
        valueForm.setName(parameterPattern.getName());
        valueForm.setInitValue(parameterPattern.getInitValue());

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
}

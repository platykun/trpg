package com.trpg.helper.Character;

import com.trpg.domain.model.character.belonging.*;
import com.trpg.domain.model.character.character.*;
import com.trpg.domain.model.character.parameter.*;
import com.trpg.form.character.common.BelongingForm;
import com.trpg.form.character.common.DetailForm;
import com.trpg.form.character.common.JobForm;
import com.trpg.form.character.common.ParameterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Helperクラスの共通項目を切り出す。
 */
@Controller
public class CharacterCommonHelper {

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
     * パラメータオブジェクトからパラメータフォームへ変換する。
     *
     * @param parameter パラメータオブジェクト
     * @return パラメータ
     */
    public ParameterForm convertToParameterForm(Parameter parameter){
        ParameterForm parameterForm = new ParameterForm();
        ParameterType parameterType = parameter.getParameterType();

        parameterForm.setParameterTypeId(parameterType.getId());
        parameterForm.setParamSubTypeId(parameter.getSubParameterTypeValue());
        parameterForm.setParameterValue(parameter.getParameter());
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
    public JobForm convertToJobForm(Job job){
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
     * 所持品オブジェクトから所持品フォームを作成する。
     *
     * @param belonging 所持品オブジェクト
     * @return 所持品フォーム
     */
    public BelongingForm convertToBelongingForm(Belonging belonging){
        int typeId = belonging.getType().getId();
        String name = belonging.getName();
        String description = belonging.getDescription();
        int belongingType = belonging.getType().getId();

        BelongingForm belongingForm = new BelongingForm(typeId, name, description, belongingType);
        return belongingForm;
    }

    /**
     * 所持品フォームから所持品オブジェクトを作成する。
     *
     * @param belongingForm 所持品フォーム
     * @return 所持品オブジェクト
     */
    public Belonging convertFormToBelonging(BelongingForm belongingForm){
        int id = belongingForm.getId();
        BelongingType belongingType = BelongingType.getType(belongingForm.getBelongingType());
        String name = belongingForm.getName();
        String description = belongingForm.getDescription();
        Belonging belonging = belongigFactory.createBelonging(id, belongingType, name, description);

        return belonging;
    }

    /**
     * パラメータオブジェクトを作成する。
     *
     * @param parameterForm パラメータフォーム
     * @return パラメータオブジェクト
     */
    public Parameter convertToParameter(ParameterForm parameterForm){
        ParameterType parameterType = ParameterType.getType(parameterForm.getParameterTypeId());

        int id = parameterForm.getId();
        int parameterValue = parameterForm.getParameterValue();
        int defaultValue = parameterForm.getInitValue();
        int subId = parameterForm.getParamSubTypeId();

        Parameter parameter = null;
        switch(parameterType){
            case CHARACTERISTICS:
                CharactristicsType charactristicsType = CharactristicsType.getType(subId);
                parameter = parameterFactory.createCharacteristics(id, parameterValue, defaultValue, charactristicsType);
                break;
            case SANITY_POINTS:
                parameter = parameterFactory.createSanityPoints(id, parameterValue, defaultValue);
                break;
            case MAGIC_POINTS:
                parameter = parameterFactory.createMagicPoints(id, parameterValue, defaultValue);
                break;
            case HIT_POINTS:
                parameter = parameterFactory.createHitPoints(id, parameterValue, defaultValue);
                break;
            case INVESTIGATOR_SKILLS:
                InvestigatorSkillType investigatorSkillType = InvestigatorSkillType.getType(subId);
                parameter = parameterFactory.createInvestigatorSkill(id, parameterValue, defaultValue, investigatorSkillType);
                break;
            case WEAPONS:
                WeaponType weaponType = WeaponType.getType(subId);
                parameter = parameterFactory.createWeapon(id, parameterValue, defaultValue, weaponType);
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
    public Detail convertToDetail(DetailForm detailForm){
        int id = detailForm.getId();
        DetailType type = DetailType.getType(detailForm.getDetailType());
        String detail = detailForm.getDetail();
        Detail detailObj = new Detail(id, type, detail);
        return detailObj;
    }


    public DetailForm convertToDetailForm(Detail detail){
        int id = detail.getId();
        int detailType = detail.getType().getId();
        String detailString = detail.getDetail();

        DetailForm detailForm = new DetailForm(id, detailType, detailString);
        return detailForm;
    }


}

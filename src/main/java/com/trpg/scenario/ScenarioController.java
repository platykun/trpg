package com.trpg.scenario;

import java.util.*;

import com.trpg.entity.CharacterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trpg.caracter.CharacterAction;
import com.trpg.entity.Scenario;

/**
 * シナリオ管理を行う画面のコントローラクラス
 * 
 * @author platykun
 *
 */
@Controller
@RequestMapping("/scenario")
public class ScenarioController {

	@Autowired
	private ScenarioAction scenarioAction;

	/**
	 * シナリオ一覧画面を表示する。
	 * @param model　モデル
	 * @return シナリオ一覧画面
	 */
	@RequestMapping("/top")
	public String top(Model model){
		List<ScenarioOutlineForm> scenarios = new ArrayList<ScenarioOutlineForm>();
		scenarioAction.getScenarioList().stream().forEach(result ->
			scenarios.add(parseScenarioOutline(result)));
		model.addAttribute("scenarios", scenarios);
		return "scenario/top";
	}
	
	/**
	 * シナリオ詳細画面を表示する。
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(Model model, String id){
		ScenarioDetail result = scenarioAction.getScenarioDetail(Integer.parseInt(id));

        ScenarioDetailForm form = new ScenarioDetailForm();
        form.setScenario(result.getScenario());
        form.setNpcs(parseScenarioCharacterForm(result.getNpcs()));
        form.setEnemies(parseScenarioCharacterForm(result.getEnemies()));

		model.addAttribute("detail", result);
		return "scenario/detail";
	}

	private ScenarioOutlineForm parseScenarioOutline(Scenario scenario) {
		return new ScenarioOutlineForm(scenario.getId(), scenario.getTitle(), scenario.getOutline());
	}

    /**
     * ScenarioCharacterFormへ変換する。
     *
     * @param cInfo キャラクター情報のリスト
     * @return 変換後のformオブジェクト
     */
	private List<ScenarioCharacterForm> parseScenarioCharacterForm(List<CharacterInfo> cInfo){
	    List<ScenarioCharacterForm> form = new ArrayList<ScenarioCharacterForm>();
	    cInfo.stream().forEach(ci -> form.add(new ScenarioCharacterForm(ci.getId(), ci.getName(), ci.getSanityPoint())));
	    return form;
    }

}

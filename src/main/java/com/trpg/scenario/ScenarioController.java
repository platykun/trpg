package com.trpg.scenario;

import java.util.ArrayList;
import java.util.List;

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
		List<Scenario> results = scenarioAction.getScenarioList();
		List<ScenarioOutlineForm> scenarios = new ArrayList<ScenarioOutlineForm>();
		results.stream().forEach(result -> 
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
		//TODO:formで格納するように修正
		model.addAttribute("detail", result);
		return "scenario/detail";
	}

	private ScenarioOutlineForm parseScenarioOutline(Scenario scenario) {
		return new ScenarioOutlineForm(scenario.getId(), scenario.getTitle(), scenario.getOutline());
	}

}

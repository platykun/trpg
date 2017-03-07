package com.trpg.scenario;

import java.util.*;

import com.trpg.entity.CharacterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.trpg.caracter.CharacterAction;
import com.trpg.entity.Scenario;

/**
 * シナリオ管理を行う画面のコントローラクラス
 * 
 * @author platykun
 *
 */
@RestController
@RequestMapping("/api/scenario")
public class ScenarioApi {

    @Autowired
    private ScenarioAction scenarioAction;

    /**
     * シナリオの詳細を返却するAPI
     */
    @RequestMapping("/top")
    public ScenarioDetail top(Integer id) {

        ScenarioDetail scenarioDetail = scenarioAction.getScenarioDetail(id);

        return scenarioDetail;
    }
}

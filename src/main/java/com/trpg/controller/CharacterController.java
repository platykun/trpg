package com.trpg.controller;

import com.trpg.domain.model.character.character.HumanList;
import com.trpg.domain.model.character.character.JobList;
import com.trpg.form.character.CharacterAddForm;
import com.trpg.form.character.CharacterDetailForm;
import com.trpg.form.character.CharacterUpdateForm;
import com.trpg.helper.Character.CharacterCreateHelper;
import com.trpg.helper.Character.CharacterDetailHelper;
import com.trpg.helper.Character.CharacterUpdateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trpg.domain.model.character.character.Human;
import com.trpg.form.character.CharacterTopForm;
import com.trpg.helper.Character.CharacterOutlineHelper;
import com.trpg.service.CharacterService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * キャラクター管理を行う画面のコントローラクラス
 * 
 * @author platykun
 *
 */
@Controller
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    CharacterOutlineHelper characterOutlineHelper;

    @Autowired
    CharacterCreateHelper characterCreateHelper;

    @Autowired
    CharacterDetailHelper characterDetailHelper;

    @Autowired
    CharacterUpdateHelper characterupdateHelper;

    /**
     * キャラクター一覧画面を表示する。
     * 
     * @param model モデル
     * @return トップ画面
     */
    @RequestMapping("/top")
    public String top(Model model) {
        HumanList allOutline = characterService.findAllOutline();
        CharacterTopForm form = characterOutlineHelper.convertToCharacterOutlineForm(allOutline);
        model.addAttribute("characters", form);

        return "character/top";
    }

     /**
     * キャラクター新規追加画面を表示する。
     *
     * @param model モデル
     * @return トップ画面
     */
     @RequestMapping("/add/input")
     public String addInput(Model model) {
         JobList jobList = characterService.getAllJob();
         Human initHuman = characterService.getInitialHuman();

         CharacterAddForm form = characterCreateHelper.convertToCreateForm(initHuman, jobList);
         model.addAttribute("character", form);

         return "character/addInput";
     }

    /**
     * キャラクターを登録する。
     *
     * @param redirectAttributes redirectAttributes
     * @param characterAddForm 入力値
     * @return キャラクター詳細画面
     */
    @RequestMapping("/add/confirm")
    public String addConfirm(RedirectAttributes redirectAttributes, CharacterAddForm characterAddForm){
        Human human = characterCreateHelper.convertToHuman(characterAddForm);

        // 詳細画面へリダイレクトするためのパラメータを設定する。
        int characterId = characterService.insertHuman(human);

        redirectAttributes.addAttribute("characterId", Integer.valueOf(characterId));

        return "redirect:/character/detail";
    }

     @RequestMapping("/detail")
    public String detail(Model model, Integer characterId){

         Human human = characterService.findHumanByCharacterId(characterId);

         CharacterDetailForm characterDetailForm = characterDetailHelper.convertToDetailForm(human);

         model.addAttribute("character", characterDetailForm);

         return "character/detail";
     }

    /**
     * キャラクター編集画面を表示する。
     *
     * @param model モデル
     * @param characterId キャラクタID
     * @return トップ画面
     */
    @RequestMapping("/update/input")
    public String updateInput(Model model, Integer characterId) {
        JobList jobList = characterService.getAllJob();
        Human human = characterService.findHumanByCharacterId(characterId);

        CharacterUpdateForm form = characterupdateHelper.convertToUpdateForm(human, jobList);
        model.addAttribute("character", form);

        return "character/updateInput";
    }

    /**
     * キャラクターの編集登録する。
     *
     * @param redirectAttributes redirectAttributes
     * @param characterUpdateForm 入力値
     * @return キャラクター詳細画面
     */
    @RequestMapping("/update/confirm")
    public String updateConfirm(RedirectAttributes redirectAttributes, CharacterUpdateForm characterUpdateForm){
        Human human = characterupdateHelper.convertToHuman(characterUpdateForm);
        // 詳細画面へリダイレクトするためのパラメータを設定する。
        characterService.updateHuman(human);

        int characterId = characterUpdateForm.getCharacterId();
        redirectAttributes.addAttribute("characterId", Integer.valueOf(characterId));

        return "redirect:/character/detail";
    }
}

package com.trpg.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.trpg.domain.model.character.character.Human;
import com.trpg.form.character.CharacterOutlineForm;
import com.trpg.form.character.CharacterOutlineListForm;

@Controller
public class CharacterOutlineHelper {
    public CharacterOutlineListForm convertToCharacterOutlineForm(Page<Human> humans) {
        List<CharacterOutlineForm> outlineFormList = new ArrayList<CharacterOutlineForm>();
        CharacterOutlineForm outlineForm = new CharacterOutlineForm(1, "2", 3);//TODO:get from humans
        outlineFormList.add(outlineForm);
        CharacterOutlineListForm form = new CharacterOutlineListForm(outlineFormList);
        return form;
    }
}

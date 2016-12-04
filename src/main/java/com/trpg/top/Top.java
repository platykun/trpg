package com.trpg.top;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 初期画面を表示する
 * @author platykun
 *
 */
@Controller
public class Top {

	/**
	 * トップ画面を表示する。
	 * @param model モデル
	 * @return フォワード先URL
	 */
	@RequestMapping("/top")
	public String top(Model model){
		return "top/top";
	}
	

	/**
	 * リクエストマッピングに指定がない場合はtop画面にフォワードする。
	 * @param model モデル
	 * @return フォワード先URL
	 */
	@RequestMapping("")
	public String forward(Model model){
		return "forward:top";
	}
	
}

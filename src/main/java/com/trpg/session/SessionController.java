package com.trpg.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * TRPGのセッション管理を行う画面のコントローラクラス
 * 
 * @author platykun
 *
 */
@Controller
@RequestMapping("/session")
public class SessionController {

	@Autowired
	SessionAction sessionAction;

	/**
	 * TRPGのセッション一覧画面を表示する。
	 * @param model　モデル
	 * @return 開催中セッション一覧画面
	 */
	@RequestMapping("/top")
	public String top(Model model){
		List<SessionOutline> sessions = sessionAction.getSessionList();
		model.addAttribute("sessions", sessions);
		return "session/top";
	}
}

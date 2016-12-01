package com.trpg.insert;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/insert")
public class InsertController {

//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// @ModelAttribute
	// InsertForm userNameForm() {
	// return new InsertForm();
	// }

	@RequestMapping("/top")
	public String home(Model model) {
		//logger.info("RegistController called", locale);

		InsertForm form = new InsertForm();
		form.setInnerText("# Marked in browser\n\nRendered by **insertForm**.");
		model.addAttribute("insertForm", form);
		
		return "insert/top";
	}

//	@RequestMapping(value = "confirm", method = RequestMethod.GET)
//	public String home2(InsertForm form) {
//	//	String name = form.getName();
//		//logger.info("name is " + name);
//
//		return "insert/confirm";
//	}

}

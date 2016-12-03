package com.trpg.insert;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trpg.entity.Scenario;

@Controller
@RequestMapping("/insert")
public class InsertController {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@RequestMapping("/top")
	public String home(Model model) {
		//logger.info("RegistController called", locale);
		SqlParameterSource param = new MapSqlParameterSource();
		Integer result = jdbcTemplate.queryForObject("select count(*) from scenario", param, Integer.class);
		

		InsertForm form = new InsertForm();
		form.setInnerText("# Marked in browser\n\nRendered by **insertForm**." + result);
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

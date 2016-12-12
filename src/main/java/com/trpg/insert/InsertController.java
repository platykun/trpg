package com.trpg.insert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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
	
    @Autowired
    ResourceLoader resourceLoader;

	@RequestMapping("/top")
	public String home(Model model) {
		// logger.info("RegistController called", locale);
		SqlParameterSource param = new MapSqlParameterSource();
		Integer result = jdbcTemplate.queryForObject("select count(*) from scenario", param, Integer.class);
		
		String filepath = "static/scenario/001.txt"; // src/main/resources 配下の相対パス
        Resource resource = resourceLoader.getResource("classpath:" + filepath);
        String name = "null";
		try {
			name = resource.getInputStream().toString();
			//name = resource.getFile().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> lines;
		StringBuilder sb = new StringBuilder();
		try {
			lines = Files.readAllLines(Paths.get(name), StandardCharsets.UTF_8);
			lines.stream().forEach(line -> {
				sb.append(line).append("\n");
			});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		InsertForm form = new InsertForm();
		form.setInnerText(sb.toString());
		model.addAttribute("insertForm", form);

		return "insert/top";
	}

	// @RequestMapping(value = "confirm", method = RequestMethod.GET)
	// public String home2(InsertForm form) {
	// // String name = form.getName();
	// //logger.info("name is " + name);
	//
	// return "insert/confirm";
	// }

}

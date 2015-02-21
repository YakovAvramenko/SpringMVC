package com.mkyong.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mkyong.common.model.DataToken;
import com.mkyong.common.service.DataService;

@Controller
@RequestMapping("/test")
@SessionAttributes("sessionData")
public class TestController {

	@Autowired
	private DataService service;

	@Autowired
	// @Qualifier("requestData")
	private DataToken sessionData;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/scopes")
	public Map<String, Object> getScopes(Model model) {
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("sessionData", sessionData.toMap());

		result.put("sessionData attr", model.asMap().get("sessionData"));

		if (!model.containsAttribute("sessionData")) {
			model.addAttribute("sessionData", sessionData.toMap());
		}
		if (!model.containsAttribute("sessionData123")) {
			model.addAttribute("sessionData123", "sessionData123");

		}
		return result;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "home";

	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/json")
	public Map<String, String> printJSON() {
		return service.findAll();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/json/{id}")
	public String printJSON(@PathVariable String id) {
		return service.findById(id);
	}
}

package com.mkyong.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkyong.common.service.DataService;

@Controller
@RequestMapping("/welcome")
public class HelloController {

  @Autowired
  private DataService service;

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

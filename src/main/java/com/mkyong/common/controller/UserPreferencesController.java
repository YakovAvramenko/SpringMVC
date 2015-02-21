package com.mkyong.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mkyong.common.model.ChatCustomer;

@Controller
@RequestMapping("/preferences")
@SessionAttributes("customer")
public class UserPreferencesController {

	@Autowired
	private ChatCustomer customer;

	@RequestMapping(method = RequestMethod.GET, value="address")
	public String mockAddress(Model model) {
		customer.setAddress("new address");
		System.out.println("customer = " + customer);
		return "customerInfo";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="all")
	@ResponseBody
	public Map getAll(Model model) {
		return customer.toMap();
	}
}

package com.mkyong.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.mkyong.common.dao.UserAccountDao;
import com.mkyong.common.model.UserAccount;
import com.mkyong.common.validator.UserLoginValidator;
import com.mkyong.common.validator.UserRegistrationValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserAccount userAccount;

	@Autowired
	private UserAccountDao userAccountDao;

	@Autowired
	private UserRegistrationValidator registrationValidator;
	@Autowired
	private UserLoginValidator loginValidator;

	@RequestMapping(method = RequestMethod.POST, value = "login")
	public String login(
			@ModelAttribute("userAccount") UserAccount userAccountIn,
			BindingResult result, SessionStatus status) {
		System.out.println("userAccountIn = " + userAccountIn);
		loginValidator.validate(userAccountIn, result);

		if (result.hasErrors()) {
			return "login";
		}

		// store in session
		userAccount = userAccountIn;
		status.setComplete();
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getCurrentUser(ModelMap request) throws Exception {
		request.addAttribute("userAccount", userAccount);
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "register")
	public String register(
			@ModelAttribute("userAccount") UserAccount userAccountIn,
			BindingResult result, SessionStatus status) {
		System.out.println("userAccountIn = " + userAccountIn);
		registrationValidator.validate(userAccountIn, result);

		if (result.hasErrors()) {
			return "register";
		}

		userAccountDao.save(userAccountIn);
		// store in session
		userAccount = userAccountIn;
		status.setComplete();
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "register")
	public String getRegister(ModelMap request) throws Exception {
		request.addAttribute("userAccount", userAccount);
		return "register";
	}

	//test
	@RequestMapping(method = RequestMethod.GET, value = "all")
	@ResponseBody
	public List<UserAccount> findAll(ModelMap request) throws Exception {
		return userAccountDao.findAll();
	}
}

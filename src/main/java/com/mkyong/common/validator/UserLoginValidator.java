package com.mkyong.common.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mkyong.common.dao.UserAccountDao;
import com.mkyong.common.model.UserAccount;

@Component
public class UserLoginValidator implements Validator {

	@Autowired
	private UserAccountDao userAccountDao;

	@Override
	public boolean supports(Class<?> arg0) {
		return UserAccount.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		String defReq = "Field name is required.";
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"required.userName", defReq);

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", defReq);

		if (errors.hasErrors()) {
			return;
		}
		UserAccount user = (UserAccount) target;

		UserAccount persistUser = userAccountDao.findByUserName(user
				.getUserName());

		if (persistUser == null
				|| !StringUtils.equals(persistUser.getPassword(),
						user.getPassword())) {
			errors.rejectValue("userName", "notmatch.credentials",
					"incorrert credentials!");
		}
	}

}

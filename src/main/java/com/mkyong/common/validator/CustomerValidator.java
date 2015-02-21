package com.mkyong.common.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mkyong.common.model.ChatCustomer;

@Component("customerValidator")
public class CustomerValidator implements Validator {

  @Override
  public boolean supports(Class< ? > arg0) {
    return ChatCustomer.class.isAssignableFrom(arg0);
  }

  @Override
  public void validate(Object target,
                       Errors errors) {
    String defReq = "Field name is required.";
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", defReq);

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", defReq);

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", defReq);

    ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                                              "confirmPassword",
                                              "required.confirmPassword",
                                              defReq);

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "required.sex", defReq);

    ChatCustomer cust = (ChatCustomer) target;

    if (!(cust.getPassword().equals(cust.getConfirmPassword()))) {
      errors.rejectValue("password", "notmatch.password");
    }
  }

}

package com.mkyong.common.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.mkyong.common.model.Customer;
import com.mkyong.common.validator.CustomerValidator;

@Controller
@RequestMapping("/customer")
public class CustomerController {
  // extends SimpleFormController

  @Autowired
  private CustomerValidator validator;
  
  @RequestMapping(method = RequestMethod.POST)
  public String save(@ModelAttribute("customer") Customer customer,
                        BindingResult result,
                        SessionStatus status) {
    System.out.println("###customer = " + customer);
    validator.validate(customer, result);

    if (result.hasErrors()) {
      System.out.println("###ooops");
      return "saveOrUpdateCustomer";
    }
    
    status.setComplete();

    return "customerInfo";
  }

  @ModelAttribute("javaSkillsList")
  public Map<String, String> populateJavaSkillList() {

    // Data referencing for java skills list box
    Map<String, String> javaSkill = new LinkedHashMap<String, String>();
    javaSkill.put("Hibernate", "Hibernate");
    javaSkill.put("Spring", "Spring");
    javaSkill.put("Apache Wicket", "Apache Wicket");
    javaSkill.put("Struts", "Struts");

    return javaSkill;
  }

  @ModelAttribute("webFrameworkList")
  public List<String> populateWebFrameworkList() {

    // Data referencing for web framework checkboxes
    List<String> webFrameworkList = new ArrayList<String>();
    webFrameworkList.add("Spring MVC");
    webFrameworkList.add("Struts 1");
    webFrameworkList.add("Struts 2");
    webFrameworkList.add("JSF");
    webFrameworkList.add("Apache Wicket");

    return webFrameworkList;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String formBackingObject(ModelMap request) throws Exception {
    System.out.println("### formBackingObject");

    Customer customer = new Customer();
    customer.setJavaSkills("Hiberante4");
    customer.setSecretValue("sevret");
    request.addAttribute("customer", customer);
    return "saveOrUpdateCustomer";
  }

}

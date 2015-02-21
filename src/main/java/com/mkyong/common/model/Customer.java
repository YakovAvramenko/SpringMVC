package com.mkyong.common.model;

import java.io.Serializable;
import java.util.Map;

@Deprecated
public interface Customer extends Serializable {

	public String getUserName();

	public void setUserName(String userName);

	public String getAddress();

	public void setAddress(String address);

	public String getPassword();

	public void setPassword(String password);

	public String getConfirmPassword();

	public void setConfirmPassword(String confirmPassword);

	public boolean isReceiveNewsletter();

	public void setReceiveNewsletter(boolean receiveNewsletter);

	public String[] getFavFramework();

	public void setFavFramework(String[] favFramework);

	public String getFavNumber();

	public void setFavNumber(String favNumber);

	public String getSex();

	public void setSex(String sex);

	public String getCountry();

	public void setCountry(String country);

	public String getJavaSkills();

	public void setJavaSkills(String javaSkills);

	public String getSecretValue();

	public void setSecretValue(String secretValue);

	public Map toMap();
}

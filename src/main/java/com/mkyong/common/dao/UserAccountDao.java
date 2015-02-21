package com.mkyong.common.dao;

import java.util.List;

import com.mkyong.common.model.UserAccount;

public interface UserAccountDao {

	List<UserAccount> findAll();
	
	UserAccount findByUserName(final String userName);
	
	UserAccount update(final UserAccount userAccount);
	
	UserAccount save(final UserAccount userAccount);
	
}

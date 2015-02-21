package com.mkyong.common.dao;

import com.mkyong.common.model.UserAccount;

public interface UserAccountDao extends GenericDao<UserAccount> {

	UserAccount findByUserName(final String userName);
}

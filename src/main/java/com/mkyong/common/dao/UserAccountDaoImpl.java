package com.mkyong.common.dao;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.mkyong.common.model.UserAccount;

@Repository
public class UserAccountDaoImpl extends AbstractDao<UserAccount> implements
		UserAccountDao {
	{
		setClazz(UserAccount.class);
	}

	@Override
	public UserAccount findByUserName(String userName) {
		for (UserAccount user : findAll()) {
			if (StringUtils.equals(user.getUserName(), userName)) {
				return user;
			}
		}
		return null;
	}
}

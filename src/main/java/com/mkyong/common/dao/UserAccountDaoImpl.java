package com.mkyong.common.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.mkyong.common.model.UserAccount;

@Repository
public class UserAccountDaoImpl implements UserAccountDao {
	
	private List<UserAccount> mocks = new ArrayList<UserAccount>();
	
	@PostConstruct
	private void init() {
		for (int i = 0; i< 10; i++) {
			UserAccount user = new UserAccount();
			
			user.setUserName("test" + i);
			user.setUserId("test" + i);
			user.setPassword("test");
			
			mocks.add(user);
		}
	}

	@Override
	public List<UserAccount> findAll() {
		return mocks;
	}

	@Override
	public UserAccount findByUserName(String userName) {
		for (UserAccount user : mocks) {
			if (StringUtils.equals(user.getUserName(), userName)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public UserAccount update(UserAccount userAccount) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UserAccount save(UserAccount userAccount) {
		mocks.add(userAccount);
		return userAccount;
	}
}

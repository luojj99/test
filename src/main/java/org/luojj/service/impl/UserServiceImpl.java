package org.luojj.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.luojj.dao.UserDao;
import org.luojj.entity.User;
import org.luojj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;

	public boolean isRegistered(String phoneNumber) {
		// TODO Auto-generated method stub
		User user = userDao.selectByPrimaryKey(phoneNumber);

		if (user == null) {
			return false;
		}
		return true;
	}

	public User checkLogin(String phoneNumber, String loginPassword) {
		// TODO Auto-generated method stub
		User user = userDao.selectByPrimaryKey(phoneNumber);

		if (user != null && user.getLoginPassword().equals(loginPassword)) {
			return user;
		} else {
			return null;
		}

	}

	public User register(String phoneNumber, String loginPassword) {
		// TODO Auto-generated method stub
		int i = 0;
		User user = new User();
		user.setPhoneNumber(phoneNumber);
		user.setLoginPassword(loginPassword);
		try {
			i = userDao.insert(user);
			if (i == 1) {
				user = userDao.selectByPrimaryKey(phoneNumber);
				return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return null;

	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateByPrimaryKey(user);
	}

	public User getUser(String phoneNumber) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(phoneNumber);
	}

}

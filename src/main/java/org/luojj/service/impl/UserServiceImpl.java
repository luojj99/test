package org.luojj.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.luojj.dao.UserMapper;
import org.luojj.entity.User;
import org.luojj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	public boolean isRegistered(String phoneNumber) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByPrimaryKey(phoneNumber);

		if (user == null) {
			return false;
		}
		return true;
	}

	public User checkLogin(String phoneNumber, String loginPassword) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByPrimaryKey(phoneNumber);

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
			i = userMapper.insert(user);
			if (i == 1) {
				user = userMapper.selectByPrimaryKey(phoneNumber);
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
		return userMapper.updateByPrimaryKey(user);
	}

	public User getUser(String phoneNumber) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(phoneNumber);
	}

}

package org.luojj.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.luojj.dao.UserDao;
import org.luojj.model.User;
import org.luojj.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
	@Resource
    private UserDao userDao;

    /* 登陆验证 */
    public User checkLogin(String phoneNumber, String loginPassword) {
        //根据用户名实例化用户对象
        User user = userDao.getUserByPhoneNumber(phoneNumber);
        if (user != null && user.getLoginPassword().equals(loginPassword)) {
            return user;
        }
        return null;
    }

	@Override
	public boolean register(String phoneNumber, String loginPassword) {
		// TODO Auto-generated method stub
		String value=phoneNumber;  
		  
		String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";  
		  
		Pattern p = Pattern.compile(regExp);  
		  
		Matcher m = p.matcher(value);  
		
		return m.find();
	
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(id);
	}
	
	
	
    
    
    
}

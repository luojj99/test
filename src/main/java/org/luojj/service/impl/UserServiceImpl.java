package org.luojj.service.impl;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.luojj.dao.UserDao;
import org.luojj.entity.User;
import org.luojj.service.IUserService;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
public class UserServiceImpl implements IUserService{
	@Resource
    private UserDao userDao;

   
	
	@Override
	public boolean isRegistered(String phoneNumber) {
		// TODO Auto-generated method stub
		User user=userDao.selectByPrimaryKey(phoneNumber);
		if (user==null) {
			return false;
		}
		return true;
	}

	@Override
	public User checkLogin(String phoneNumber, String loginPassword) {
		// TODO Auto-generated method stub
		User user = userDao.selectByPrimaryKey(phoneNumber);
	       
        if (user != null && user.getLoginPassword().equals(loginPassword)) {
            return user;
        }else{
        	return null;
        }
     
	}

	@Override
	public User register(String phoneNumber, String loginPassword) {
		// TODO Auto-generated method stub
		String value=phoneNumber;  
		int i=0;
		User user;
		String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";  
		  
		Pattern p = Pattern.compile(regExp);  
		  
		Matcher m = p.matcher(value);  
		
		boolean isPhoneNumberValid = m.find();
		
		if (isPhoneNumberValid) {
			user = new User();
			user.setPhoneNumber(phoneNumber);
			
			try {
				i=userDao.insert(user);
				if (i==1) {
					user=userDao.selectByPrimaryKey(phoneNumber);
					return user;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
		
		return null;

	}
	
	
	
    
    
    
}

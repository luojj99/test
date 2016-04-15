package org.luojj.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.luojj.dao.UserDao;
import org.luojj.entity.User;
import org.luojj.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class UserServiceImpl implements IUserService{
	@Resource
    private UserDao userDao;

   
	
	
	public boolean isRegistered(String phoneNumber) {
		// TODO Auto-generated method stub
		User user=userDao.selectByPrimaryKey(phoneNumber);
		if (user==null) {
			return false;
		}
		return true;
	}

	
	public User checkLogin(String phoneNumber, String loginPassword) {
		// TODO Auto-generated method stub
		User user = userDao.selectByPrimaryKey(phoneNumber);
	       
        if (user != null && user.getLoginPassword().equals(loginPassword)) {
            return user;
        }else{
        	return null;
        }
     
	}

	
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
			user.setLoginPassword(loginPassword);
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


	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateByPrimaryKey(user);
	}


	public User getUser(String phoneNumber) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(phoneNumber);
	}
	
	
	
    
    
    
}

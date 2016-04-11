package org.luojj.controller;

import java.util.HashMap;

import java.util.Map;

import javax.annotation.Resource;
import javax.json.Json;

import org.apache.log4j.Logger;
import org.luojj.dao.Message;
import org.luojj.model.User;
import org.luojj.service.IUserService;
import org.luojj.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.NEW;




@Controller
public class UserController {
	 private static Logger logger = Logger.getLogger(UserController.class);  
	 boolean isRegistered;
	 String phoneNumber;
//	 static Message message=new Message();
	@Resource
    private IUserService userService;
	
	
	@ResponseBody
	@RequestMapping(value="isRegistered/{phoneNumber}",method=RequestMethod.GET)
	public Message isRegistered(@PathVariable String phoneNumber){
		 isRegistered=userService.isRegistered(phoneNumber);
		 logger.info(isRegistered);
		this.phoneNumber=phoneNumber;
		if (isRegistered) {
			
			return new Message("registered");
			
		}
		return new Message("unregistered");
	}
	
	@ResponseBody
	@RequestMapping(value="choose/{loginPassword}")
	public User choseLoginORRegeister(@PathVariable String loginPassword){
		logger.info("start");
		logger.info(isRegistered);
		if (isRegistered) {
			return login(loginPassword);
		}
		else {
			return register(loginPassword);
		}
	}
	
	
    public  User login(String loginPassword)  {
			
			 User user=userService.checkLogin(phoneNumber,loginPassword);
		        if(user!=null){
		        	 
		        	logger.info("login success");
		            return user;          
		        }
		        logger.info("login fail");
		        return null;
       
    }
    
    
    public  User register( String loginPassword)  {
    	User user=userService.register(phoneNumber, loginPassword);
    	if (user!=null) {
			logger.info("success"+JSON.toJSONString(user));
		}else{
			logger.info("fail");
		}
    	return user;
    	
    }
    
    
    
    
}

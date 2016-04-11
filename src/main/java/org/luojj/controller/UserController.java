package org.luojj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.json.Json;

import org.apache.log4j.Logger;
import org.luojj.model.User;
import org.luojj.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;




@Controller
public class UserController {
	 private static Logger logger = Logger.getLogger(UserController.class);  
	 boolean isRegistered;
	 String phoneNumber;
	@Resource
    private IUserService userService;
	
	
	@ResponseBody
	@RequestMapping(value="isRegistered/{phoneNumber}",method=RequestMethod.GET)
	public String isRegistered(@PathVariable String phoneNumber){
		 isRegistered=userService.isRegistered(phoneNumber);
		 logger.info(isRegistered);
		this.phoneNumber=phoneNumber;
		if (isRegistered) {
			
			return JSON.toJSONString("registered");
			
		}
		return JSON.toJSONString("unregistered");
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

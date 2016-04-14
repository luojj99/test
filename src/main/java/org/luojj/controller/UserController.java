package org.luojj.controller;

import java.util.HashMap;

import java.util.Map;

import javax.annotation.Resource;
import javax.json.Json;

import org.apache.log4j.Logger;
import org.luojj.entity.Message;
import org.luojj.entity.User;
import org.luojj.listener.OnLoginListener;
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
	
//	 static Message message=new Message();
	@Resource
    private IUserService userService;
	
	
	@ResponseBody
	@RequestMapping(value="isRegistered/{phoneNumber}",method=RequestMethod.GET)
	public String isRegistered(@PathVariable String phoneNumber){
		 boolean isRegistered=userService.isRegistered(phoneNumber);
		 logger.info(isRegistered);
		if (isRegistered) {
			
			return JsonUtil.msg2Json("registered");
			
		}
		return JsonUtil.msg2Json("unregistered");
	}
	
	@ResponseBody
	@RequestMapping(value="choose/phoneNumber/{phoneNumber}/loginPassword/{loginPassword}",method=RequestMethod.GET)
	public User choose(@PathVariable String phoneNumber,
    		@PathVariable String loginPassword){
		boolean isRegistered = userService.isRegistered(phoneNumber);
		if (isRegistered) {
			return login(phoneNumber, loginPassword);
		}else{
			return register(phoneNumber, loginPassword);
		}
	}
	
	
    public  User login( String phoneNumber, String loginPassword)  {
			
			 User user=userService.checkLogin(phoneNumber,loginPassword);
		        if(user==null){
		        	
		        user=new User();
		        user.setMessage("password error");
		        }
		        logger.info(JSON.toJSONString(user));
		        return user;
       
    }
    
    public  User register(String phoneNumber, String loginPassword)  {
    	User user=userService.register(phoneNumber, loginPassword);
    	if (user==null) {
		user=new User();
		user=setMessage("register success");
		}
    	logger.info(JSON.toJSONString(user));
    	return user;
    	
    }

	
    
    
    
    
}

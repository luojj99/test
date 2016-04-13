package org.luojj.controller;

import java.util.HashMap;

import java.util.Map;

import javax.annotation.Resource;
import javax.json.Json;

import org.apache.log4j.Logger;
import org.luojj.listener.OnLoginListener;
import org.luojj.model.Message;
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
public class UserController implements OnLoginListener{
	 private static Logger logger = Logger.getLogger(UserController.class);  
	 boolean isRegistered;
	 String phoneNumber;
//	 static Message message=new Message();
	@Resource
    private IUserService userService;
	
	
	@ResponseBody
	@RequestMapping(value="isRegistered/{phoneNumber}",method=RequestMethod.GET)
	public String isRegistered(@PathVariable String phoneNumber){
		 isRegistered=userService.isRegistered(phoneNumber);
		 logger.info(isRegistered);
		this.phoneNumber=phoneNumber;
		if (isRegistered) {
			
			return JsonUtil.msg2Json("registered");
			
		}
		return JsonUtil.msg2Json("unregistered");
	}
	
	@ResponseBody
	@RequestMapping(value="choose/{loginPassword}")
	public User choseLoginORRegeister(@PathVariable String loginPassword){
		
		if (isRegistered) {
			return login(loginPassword);
		}
		else {
			return register(loginPassword);
		}
	}
	
	
    public  User login(String loginPassword)  {
			
			 User user=userService.checkLogin(phoneNumber,loginPassword);
		        if(user==null){
		        	user = new User("paasword error");
		        }
		        logger.info(JSON.toJSONString(user));
		        return user;
       
    }
    
    
    public  User register(String loginPassword)  {
    	User user=userService.register(phoneNumber, loginPassword);
    	if (user==null) {
    		user = new User("fail");
		}
    	logger.info(JSON.toJSONString(user));
    	return user;
    	
    }

	@Override
	public void onError(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuccess(User user) {
		// TODO Auto-generated method stub
		
	}
    
    
    
    
}

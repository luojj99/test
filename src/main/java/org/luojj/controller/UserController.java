package org.luojj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.luojj.model.User;
import org.luojj.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class UserController {
	 private static Logger logger = Logger.getLogger(UserController.class);  
	
	@Resource
    private IUserService userService;
	
	@ResponseBody
    @RequestMapping(value="/login/phoneNumber/{phoneNumber}/loginPassword/{loginPassword}",method=RequestMethod.GET)
    public  User login(@PathVariable String phoneNumber,
    		@PathVariable String loginPassword)  {
        User user=userService.checkLogin(phoneNumber,loginPassword);
        if(user!=null){
        	 
        	logger.info("login success");
            return user;          
        }
        logger.info("login fail");
        return null;
    }
    
    
    
	@ResponseBody
    @RequestMapping(value="/register/phoneNumber/{phoneNumber}/loginPassword/{loginPassword}",method=RequestMethod.GET)
    public  User register(@PathVariable String phoneNumber,
    		@PathVariable String loginPassword)  {
    	User user=userService.register(phoneNumber, loginPassword);
    	
    	return user;
    	
    }
    
    
    
    
}

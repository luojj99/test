package org.luojj.controller;

import javax.annotation.Resource;
import javax.mail.Flags.Flag;

import org.apache.log4j.Logger;
import org.luojj.model.User;
import org.luojj.service.IUserService;
import org.luojj.test.TestMybatis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	 private static Logger logger = Logger.getLogger(UserController.class);  
	
	@Resource
    private IUserService userService;
	
    @RequestMapping(value="/login/phoneNumber/{phoneNumber}/loginPassword/{loginPassword}",method=RequestMethod.GET)
    public @ResponseBody User login(@PathVariable String phoneNumber,
    		@PathVariable String loginPassword)  {
        User user=userService.checkLogin(phoneNumber, loginPassword);
        if(user!=null){
        	logger.info("login success");
        	//fsdfs
            return user;          
        }
        logger.info("login fail");
        return null;
    }
    
    @RequestMapping(value="/register/phoneNumber/{phoneNumber}/loginPassword/{loginPassword}",method=RequestMethod.GET)
    public @ResponseBody boolean register(@PathVariable String phoneNumber,
    		@PathVariable String loginPassword)  {
    	boolean flag=userService.register(phoneNumber, loginPassword);
    	return flag;
    	
    }
    
    
    
    
}

package org.luojj.controller;

//工具类静态导入



import org.apache.ibatis.annotations.Options;
import org.apache.log4j.Logger;
import org.luojj.baseclass.BasicObject;
import org.luojj.entity.User;
import org.luojj.service.IUserService;
import org.luojj.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;





@Controller
public class UserController extends BasicController{
	 private static Logger logger = Logger.getLogger(UserController.class);  
	
//	 static Message message=new Message();
	@Autowired
    private IUserService userService;
	
	@Options(flushCache=true)
	@ResponseBody
	@RequestMapping(value="isRegistered/{phoneNumber}",method=RequestMethod.GET)
	public BasicObject isRegistered(@PathVariable String phoneNumber){
		 boolean isRegistered=userService.isRegistered(phoneNumber);
		 logger.info(isRegistered);
		if (isRegistered) {
			
			return SUCCESS("registered");
		}
		return FAIL("unregistered");
	}
	
	@Options(flushCache=true)
	@ResponseBody
	@RequestMapping(value="choose/phoneNumber/{phoneNumber}/loginPassword/{loginPassword}",method=RequestMethod.GET)
	public BasicObject choose(@PathVariable String phoneNumber,
    		@PathVariable String loginPassword){
		boolean isRegistered = userService.isRegistered(phoneNumber);
		if (isRegistered) {
			return login(phoneNumber, loginPassword);
		}else{
			return register(phoneNumber, loginPassword);
		}
	}
	
	
    public  BasicObject login( String phoneNumber, String loginPassword)  {
			
			 User user=userService.checkLogin(phoneNumber,loginPassword);
		        if(user==null){
		        	return  FAIL("password error");
		        }
		        SUCCESS(user);
		        logger.info(JSON.toJSONString(user));
		        return user;
       
    }
    
    public  BasicObject register(String phoneNumber, String loginPassword)  {
    	User user=userService.register(phoneNumber, loginPassword);
    	if (user==null) {
    		return FAIL("register fail");
		}
		SUCCESS(user);
    	logger.info(JSON.toJSONString(user));
    	return user;
    	
    }
    
    @ResponseBody
    @RequestMapping(value="/user/update",method=RequestMethod.GET)
    public BasicObject updateUser(@ModelAttribute User user){
    	try {
    		
    		int status=userService.updateUser(user);
        	if (status==1) {
    			return SUCCESS("update success");
    		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return FAIL("update fail");
    }
    
    
    @ResponseBody
    @RequestMapping(value="/user/select/{phoneNumber}",method=RequestMethod.GET)
    public BasicObject getUser(@PathVariable String phoneNumber){
    	User user =  userService.getUser(phoneNumber);
    	if (user==null) {
			return FAIL("user null");
		}else{
			return SUCCESS(user);
		}
    }

	
    
    
    
    
}

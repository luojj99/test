package org.luojj.controller;

//工具类静态导入



import java.lang.reflect.Method;

import java.util.Map;

import javax.json.JsonObject;

import org.apache.ibatis.annotations.Options;
import org.apache.log4j.Logger;
import org.luojj.baseclass.BaseController;
import org.luojj.baseclass.BaseBean;
import org.luojj.entity.User;
import org.luojj.service.IUserService;
import org.luojj.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;





@Controller
public class UserController extends BaseController{
	 private static Logger logger = Logger.getLogger(UserController.class);  
	
//	 static Message message=new Message();
	@Autowired
    private IUserService userService;
	
	/** 
	 *  解决部分更新问题
	 *  有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!  
	 *  该方法会从数据库拉取数据，然后放在map中，springmvc就会把从参数获取得到的bean也添加到map中，
	 *  把从参数获取得到的bean的空字段和拉取的bean合并
	 */  
	@ModelAttribute  
	public void fixUpdateMethod(@RequestParam(value="phoneNumber",required=false) String phoneNumber,   
	        Map<String, Object> map){  
	    logger.info("modelAttribute method");  
	    if(phoneNumber != null){  
	        User user=userService.getUser(phoneNumber);  
	        logger.info("数据库原数据："+JSON.toJSONString(user));
	        map.put("user", user);  
	    }  
	}  
	
	@ResponseBody
	@RequestMapping(value="isRegistered/{phoneNumber}",method=RequestMethod.GET)
	public BaseBean isRegistered(@PathVariable String phoneNumber){
		 boolean isRegistered=userService.isRegistered(phoneNumber);
		 logger.info(isRegistered);
		if (isRegistered) {
			
			return SUCCESS("registered");
		}
		return FAIL("unregistered");
	}
	
	
	@ResponseBody
	@RequestMapping(value="choose/phoneNumber/{phoneNumber}/loginPassword/{loginPassword}",method=RequestMethod.GET)
	public BaseBean choose(@PathVariable String phoneNumber,
    		@PathVariable String loginPassword){
		boolean isRegistered = userService.isRegistered(phoneNumber);
		if (isRegistered) {
			return login(phoneNumber, loginPassword);
		}else{
			return register(phoneNumber, loginPassword);
		}
	}
	
	
    public  BaseBean login( String phoneNumber, String loginPassword)  {
			
			 User user=userService.checkLogin(phoneNumber,loginPassword);
		        if(user==null){
		        	return  FAIL("password error");
		        }
		        logger.info(JSON.toJSONString(user));
		        return SUCCESS(null, user);
		        
    }
    
    public  BaseBean register(String phoneNumber, String loginPassword)  {
    	User user=userService.register(phoneNumber, loginPassword);
    	
    	if (user==null) {
    		return FAIL("register fail");
		}
    	logger.info(JSON.toJSONString(user));
    	return SUCCESS( null,user);
    	
    }
    
    
    @ResponseBody
    @RequestMapping(value="/user/update",method=RequestMethod.POST)
    public BaseBean updateUser(@ModelAttribute User user){
    	try {
    		logger.info("客户端传来的数据："+JSON.toJSONString(user));
    		int status=userService.updateUser(user);
    		User afterUpdateUser = userService.getUser(user.getPhoneNumber());
        	if (status==1) {
        		logger.info("更新后数据库数据："+JSON.toJSONString(afterUpdateUser));
    			return SUCCESS("update success:",afterUpdateUser);
    		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return FAIL("update fail");
    }
    
    
    @ResponseBody
    @RequestMapping(value="/user/select/{phoneNumber}",method=RequestMethod.GET)
    public BaseBean getUser(@PathVariable String phoneNumber){
    	User user =  userService.getUser(phoneNumber);
    	if (user==null) {
			return FAIL("user null");
		}else{
			return SUCCESS(null, user);
		}
    }

	
    
    
    
    
}

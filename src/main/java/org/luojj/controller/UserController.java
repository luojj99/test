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
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {
	 private static Logger logger = Logger.getLogger(UserController.class);  
	
	@Resource
    private IUserService userService;
	
    @RequestMapping(value="/login/phoneNumber/{phoneNumber}/loginPassword/{loginPassword}",method=RequestMethod.GET)
    public  ModelAndView login(@PathVariable String phoneNumber,
    		@PathVariable String loginPassword)  {
        User user=userService.checkLogin(phoneNumber,loginPassword);
        System.out.println(22222);
        if(user!=null){
        	ModelAndView modelView=new ModelAndView(); 
            Map<String,Object> modelMap=new HashMap<String,Object>(); 
            modelMap.put("loginPassword", loginPassword);
            modelMap.put("phoneNumber", phoneNumber);
            modelMap.put("user", user);
        	modelView.addAllObjects(modelMap);  
        	logger.info("login success");
        	System.out.println(1111111111);
            return modelView;          
        }
        logger.info("login fail");
        return null;
    }
    
    
//    public ModelAndView queryFoodList(@RequestParam("typeId") int typeId){  
//        
//        List<Food> list=foodService.getFoodListByType(typeId);  
//        ModelAndView modelView=new ModelAndView();  
//        Map<String,Object> modelMap=new HashMap<String,Object>();  
//        modelMap.put("FOOD_LIST", list);  
//        modelMap.put("TYPE_ID", typeId);  
//        modelView.addAllObjects(modelMap);  
//        return modelView;  
//    }  
    
    
    @RequestMapping(value="/register/phoneNumber/{phoneNumber}/loginPassword/{loginPassword}",method=RequestMethod.GET)
    public @ResponseBody boolean register(@PathVariable String phoneNumber,
    		@PathVariable String loginPassword)  {
    	boolean flag=userService.register(phoneNumber, loginPassword);
    	return flag;
    	
    }
    
    
    
    
}

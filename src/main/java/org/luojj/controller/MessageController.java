package org.luojj.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.luojj.baseclass.BaseBean;
import org.luojj.baseclass.BaseController;
import org.luojj.dao.AssetMapper;
import org.luojj.dao.MessageCenterMapper;
import org.luojj.dao.UserMapper;
import org.luojj.entity.Asset;
import org.luojj.entity.MessageCenter;
import org.luojj.entity.User;
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
public class MessageController  extends BaseController{
	
 private static Logger logger = Logger.getLogger(AssetController.class);  
	 
	 @Autowired
	 private MessageCenterMapper messageCenterMapper;
	 
	 @Autowired
	 private UserMapper userMapper;
	
	/** 
	 *  解决部分更新问题
	 *  有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!  
	 *  该方法会从数据库拉取数据，然后放在map中，springmvc就会把从参数获取得到的bean也添加到map中，
	 *  把从参数获取得到的bean的空字段和拉取的bean合并
	 */  
//	@ModelAttribute  
//	public void fixUpdateMethod(@RequestParam(value="phoneNumber",required=false) String phoneNumber,   
//	        Map<String, Object> map){  
//	    logger.info("modelAttribute method");  
////	    if(phoneNumber != null){  
////	        Asset asset=assetMapper.selectByPrimaryKey(phoneNumber);
////	        map.put("asset", asset);  
////	    }  
//	}  
//	
//	
//	@ResponseBody
//	@RequestMapping(value="msgCenter/insert",method=RequestMethod.POST,headers={"content-type=application/json","content-type=application/xml"})
//	public BaseBean insertMessage(@RequestBody MessageCenter messageCenter ){
//		try {
//			User user =userMapper.selectByPrimaryKey(messageCenter.getPhoneNumber());
//			if (user!=null) {
//				messageCenterMapper.insert(messageCenter);
//				return SUCCESS(null, messageCenter);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return FAIL("insert fail");
//		
//	}
//	
//	
//	@ResponseBody
//	@RequestMapping(value="msgCenter/update",method=RequestMethod.POST,headers={"content-type=application/json","content-type=application/xml"})
//	public BaseBean updateMessage(@RequestBody MessageCenter messageCenter){
//		try {
//    		
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return FAIL("update fail");
//	}
	
	
//	@ResponseBody
//    @RequestMapping(value="/msgCenter/getMsgListByPhoneNo/{phoneNumber}",method=RequestMethod.GET)
//    public String getMsgListByPhoneNumber(@PathVariable String phoneNumber){
//		List<MessageCenter> msgList =  new ArrayList<MessageCenter>();
//		try {
//			msgList = messageCenterMapper.findMessageByPhoneNumber(phoneNumber);
//			return JSON.toJSONString(msgList);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return JSON.toJSONString(FAIL("select fail"));
//    }
	
	@ResponseBody
    @RequestMapping(value="/msgCenter/getMsgList",method=RequestMethod.GET)
    public String getMsgList(){
		List<MessageCenter> msgList =  new ArrayList<MessageCenter>();
		try {
			msgList = messageCenterMapper.getMsgList();
			return JSON.toJSONString(msgList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return JSON.toJSONString(FAIL("select fail"));
    }

}

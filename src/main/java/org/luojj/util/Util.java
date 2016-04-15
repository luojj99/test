package org.luojj.util;

import org.apache.log4j.Logger;
import org.luojj.baseclass.BasicObject;

import com.alibaba.fastjson.JSON;

public class Util {
private static Logger logger = Logger.getLogger(Util.class);  
	
	public static String Str2Json(String content){
		
		return "{\"message\":\""+content+"\"}";
	}
	
	public static BasicObject SUCCESS(BasicObject basicObject){
		basicObject.setErrorCode(0);
		
		logger.info(JSON.toJSONString(basicObject));
		return basicObject;
	}
	
	/**
	 * message被暂时注销 不起作用
	 * @param message
	 * @return
	 */
	public static BasicObject SUCCESS(String message){
		BasicObject basicObject = new BasicObject();
		basicObject.setErrorCode(0);
//		basicObject.setMessage(message);
		logger.info(JSON.toJSONString(basicObject));
		return basicObject;
	}
	
	public static BasicObject SUCCESS(){
		BasicObject basicObject = new BasicObject();
		basicObject.setErrorCode(0);
		
		logger.info(JSON.toJSONString(basicObject));
		return basicObject;
	}
	
	/**
	 * 错误信息处理
	 * @param message
	 * @return
	 */
	public static BasicObject FAIL(String message){
		BasicObject basicObject = new BasicObject();
		basicObject.setErrorCode(1);
		basicObject.setMessage(message);
		logger.info(JSON.toJSONString(basicObject));
		return basicObject;
	}
	
	
}

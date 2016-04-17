package org.luojj.util;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.luojj.baseclass.BaseBean;

import com.alibaba.fastjson.JSON;

public class Util {
private static Logger logger = Logger.getLogger(Util.class);  
	
	public static String Str2Json(String content){
		
		return "{\"message\":\""+content+"\"}";
	}
	
	public static BaseBean SUCCESS(BaseBean basicObject){
		basicObject.setErrorCode(0);
		basicObject.setMessage("SUCCESS");
		logger.info(JSON.toJSONString(basicObject));
		return basicObject;
	}
	
	/**
	 * 
	 * @param message
	 * @return
	 */
	public static BaseBean SUCCESS(String message){
		BaseBean basicObject = new BaseBean();
		basicObject.setErrorCode(0);
		basicObject.setMessage(message);
		logger.info(JSON.toJSONString(basicObject));
		return basicObject;
	}
	
	public static BaseBean SUCCESS(){
		BaseBean basicObject = new BaseBean();
		basicObject.setErrorCode(0);
		basicObject.setMessage("SUCCESS");
		logger.info(JSON.toJSONString(basicObject));
		return basicObject;
	}
	
	/**
	 * 错误信息处理
	 * @param message
	 * @return
	 */
	public static BaseBean FAIL(String message){
		BaseBean basicObject = new BaseBean();
		basicObject.setErrorCode(1);
		basicObject.setMessage(message);
		logger.info(JSON.toJSONString(basicObject));
		return basicObject;
	}
	
	
	public static String encodeStr(String str) {  
        try {  
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
	
	
}

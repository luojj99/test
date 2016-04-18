package org.luojj.baseclass;

//工具类静态导入
import static org.luojj.util.Util.Str2Json;

import org.luojj.util.Util;

import static org.luojj.util.Util.SUCCESS;
import static org.luojj.util.Util.FAIL;

public class BaseController {
	/**
	 * 正确信息处理（包括用户信息）
	 * message 可以为null
	 * @param basicObject
	 * @param message TODO
	 * @return
	 */
	public static BaseBean SUCCESS(BaseBean basicObject, String message){
//		return Util.SUCCESS(basicObject,String message);
		return Util.SUCCESS(basicObject, message);
	}
	
	/**
	 * 正确信息处理（不包括用户信息）
	 * 
	 * @param message
	 * @return
	 */
	public static BaseBean SUCCESS(String message){
		return Util.SUCCESS(message);
	}
	
	public static BaseBean SUCCESS(){
		return Util.SUCCESS();
	}
	
	
	
	/**
	 * 错误信息处理
	 * @param message
	 * @return
	 */
	public static BaseBean FAIL(String  message){
		return Util.FAIL(message);
	}
	
	public static String Str2Json(String content){
		return Util.Str2Json(content);
	}
	
}

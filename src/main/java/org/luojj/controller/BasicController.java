package org.luojj.controller;

//工具类静态导入
import static org.luojj.util.Util.Str2Json;

import org.luojj.baseclass.BasicObject;
import org.luojj.util.Util;

import static org.luojj.util.Util.SUCCESS;
import static org.luojj.util.Util.FAIL;

public class BasicController {
	/**
	 * 正确信息处理
	 * @param basicObject
	 * @return
	 */
	public static BasicObject SUCCESS(BasicObject basicObject){
		return Util.SUCCESS(basicObject);
	}
	
	public static BasicObject SUCCESS(String message){
		return Util.SUCCESS(message);
	}
	
	/**
	 * 错误信息处理
	 * @param message
	 * @return
	 */
	public static BasicObject FAIL(String  message){
		return Util.FAIL(message);
	}
	
	public static String Str2Json(String content){
		return Util.Str2Json(content);
	}
	
}

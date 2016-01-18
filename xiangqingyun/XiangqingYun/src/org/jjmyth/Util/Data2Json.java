package org.jjmyth.Util;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


import org.jjmyth.DODAO.Users;
import org.jjmyth.DODAO.UsersDAO;

import com.sun.org.apache.bcel.internal.generic.RETURN;



//将数据库的内容变成json文件，客户端直接读json文件
public class Data2Json {
	public static void tranData2JsonFile(List<Users> list){
		try {
			String path = "F://Tomcat-6.0.33//webapps//XiangqingYun//data.json";
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
				OutputStream outputStream = new FileOutputStream(file);
				StringBuffer sb =new StringBuffer();
				sb.append("[");
				int i=0;
				for (Users users : list) {
					i++;
					sb.append(users.toJSONString());
					if(i==list.size()){
						break;
					}else{
						sb.append(",");
					}
				}
				sb.append("]");
				outputStream.write(sb.toString().getBytes());
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
}

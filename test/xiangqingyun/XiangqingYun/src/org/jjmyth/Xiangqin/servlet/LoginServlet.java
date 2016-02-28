package org.jjmyth.Xiangqin.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jjmyth.DODAO.Users;
import org.jjmyth.DODAO.UsersDAO;
import org.jjmyth.Util.EncryptTools;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LoginServlet extends HttpServlet {
	//log4j日志初始化
	public static Logger logger = Logger.getLogger(LoginServlet.class);
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		doPost(request, response);
		
	}
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String tag=request.getParameter("tag");
		if(tag.equals("android")){
			
			String time=request.getParameter("time");
			String name=request.getParameter("username");
			String idstr = request.getParameter("id");
			UsersDAO usersDAO = new UsersDAO();
			
			//当参数只有name时，说明是第一次登陆
			if (name!=null) {
				
				
				String pass=request.getParameter("password");
				boolean flag=usersDAO.login(name, pass);
				if(flag){
					logger.debug("第一次登陆");
					Users users = usersDAO.findUserByUsername(name);
					usersDAO.updateToken(users);
					//返回信息
					
					String data = usersDAO.findUserByUsername(name).toJSONStringHaveToken();
					System.out.println(data);
					out.print(data);
					
				}else{
					out.print("error");
				}
			}
			
			//当参数有id时，说明使用token登陆
			if (idstr!=null) {
				logger.debug("正常登陆");
			
				int id = Integer.parseInt(idstr);
				Users normalUsers = usersDAO.findById(id);
				String signature = request.getParameter("signature");
				logger.debug(signature);
				String token =normalUsers.getToken();
				
				if (judgeTimeDifference(time)==true) {
					if (compareSignature(time, signature, token)) {
						
						String data = normalUsers.toJSONString();
						System.out.println("使用token登陆---"+data);
						out.print(data);
					}else {
						logger.debug("签名不正确");
						out.print("error");
					}
				}else {
					logger.debug("客户端与服务器有时间差");
					out.print("客户端与服务器有时间差");
				}
			}
		}
		
	}
	
	
	
	
	public boolean compareSignature(String time,String signature,String token){
		String signatureServer=EncryptTools.SHA256Encrypt(time+token);
		logger.debug(time+"       "+token);
		logger.debug(signatureServer);
		if (signatureServer.equals(signature)) {
			return true;
		}
		return false;
	}
	
	public boolean judgeTimeDifference(String time){
		
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Date now = new Date();
			Date androidTime;
			androidTime = df.parse(time);
			long diff = now.getTime() - androidTime.getTime();
			long minDelta = diff / (1000 * 60 );
			if (minDelta<=600) {
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	
	

}

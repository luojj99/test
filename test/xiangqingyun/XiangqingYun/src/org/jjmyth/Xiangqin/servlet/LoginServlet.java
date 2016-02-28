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
	//log4j��־��ʼ��
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
			
			//������ֻ��nameʱ��˵���ǵ�һ�ε�½
			if (name!=null) {
				
				
				String pass=request.getParameter("password");
				boolean flag=usersDAO.login(name, pass);
				if(flag){
					logger.debug("��һ�ε�½");
					Users users = usersDAO.findUserByUsername(name);
					usersDAO.updateToken(users);
					//������Ϣ
					
					String data = usersDAO.findUserByUsername(name).toJSONStringHaveToken();
					System.out.println(data);
					out.print(data);
					
				}else{
					out.print("error");
				}
			}
			
			//��������idʱ��˵��ʹ��token��½
			if (idstr!=null) {
				logger.debug("������½");
			
				int id = Integer.parseInt(idstr);
				Users normalUsers = usersDAO.findById(id);
				String signature = request.getParameter("signature");
				logger.debug(signature);
				String token =normalUsers.getToken();
				
				if (judgeTimeDifference(time)==true) {
					if (compareSignature(time, signature, token)) {
						
						String data = normalUsers.toJSONString();
						System.out.println("ʹ��token��½---"+data);
						out.print(data);
					}else {
						logger.debug("ǩ������ȷ");
						out.print("error");
					}
				}else {
					logger.debug("�ͻ������������ʱ���");
					out.print("�ͻ������������ʱ���");
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
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
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

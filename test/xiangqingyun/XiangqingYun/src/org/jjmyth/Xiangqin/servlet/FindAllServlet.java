package org.jjmyth.Xiangqin.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import javax.xml.ws.Response;

import org.jjmyth.DODAO.Users;
import org.jjmyth.DODAO.UsersDAO;
import org.jjmyth.Util.Data2Json;
import org.omg.CORBA.PUBLIC_MEMBER;

public class FindAllServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindAllServlet() {
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
		//String tag=request.getParameter("tag");
		UsersDAO usersDAO = new UsersDAO();
		String tag="android";
		List<Users>list=usersDAO.findAll();
		List<String> picNameList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			picNameList.add(list.get(i).getPic());
		}
		Data2Json.tranData2JsonFile(list);
		
		if(tag.equals("android")){
			
			out.print(readJsonFile());
			System.out.println("list success");
		}else if (tag.equals("web")) {
			
		}else{
			System.out.println("be visted, but  findAll error");
		}
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	
	public String readJsonFile(){
		
		String pathname = "F://Tomcat-6.0.33//webapps//XiangqingYun//data.json";
		File file = new File(pathname);
		Reader reader;
		try {
			reader = new InputStreamReader(new FileInputStream(file));
			int tempChar;
			String jsonString="" ;
			while ((tempChar=reader.read())!=-1) {
				jsonString +=(char)tempChar;
			}
			return jsonString;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ERROR";
	}

}

package org.jjmyth.Xiangqin.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jjmyth.DODAO.Users;
import org.jjmyth.DODAO.UsersDAO;
import org.jjmyth.Util.Data2Json;
import org.jjmyth.Util.EncryptTools;


public class RegisterSerlvet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterSerlvet() {
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
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		String tag=request.getParameter("tag");
		UsersDAO usersDAO = new UsersDAO();
		
		if(tag.equals("android")){
			String sexEN=request.getParameter("sex");
			String sex=null;
			if(sexEN.equals("male")){
				sex="ÄÐ";
			}else{
				sex="Å®";
			}
			
			String  pic = request.getParameter("pic");
			//Integer pic =Integer.parseInt(picstr);
			boolean flag;
			
			flag = usersDAO.register(name, EncryptTools.AESDecrypt(pass),sex,pic);
			
			if(flag){
				System.out.println("android register success");
				List<Users>list=usersDAO.findAll();
				out.print("success");
			}else{
				out.print("error");
			}
		}else if(tag.equals("web")){
			boolean flag=usersDAO.register(name, pass);
			if(flag){
				
				System.out.println("web register success");
				response.sendRedirect("../success.html");
			}else{
				response.sendRedirect("index.jsp");
			}
		}else{
			System.out.println("be visited, but register error");
		}
			
		
		
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
		doGet(request, response);
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

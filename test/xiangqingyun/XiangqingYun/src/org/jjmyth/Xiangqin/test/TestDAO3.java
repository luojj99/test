package org.jjmyth.Xiangqin.test;

import org.jjmyth.DODAO.UsersDAO;

public class TestDAO3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsersDAO usersDAO = new  UsersDAO();
		System.out.println(""+usersDAO.login("aaa", "111111"));
	}
	
}

package org.jjmyth.DODAO;



import java.security.SecureRandom;
import java.sql.CallableStatement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.xml.registry.infomodel.User;

import org.apache.log4j.Logger;
import org.jjmyth.Util.EncryptTools;
import org.jjmyth.Xiangqin.servlet.LoginServlet;



public class UsersDAO {
	//log4j日志初始化
	public static Logger logger = Logger.getLogger(LoginServlet.class);
	PreparedStatement  preparedStatement =null;
	Connection connection = null;
	ResultSet resultSet = null;
	private Integer loginId;
	
	
	
	public Integer getLoginId() {
		return loginId;
	}
	

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	

	public Users findById(Integer id){
		try {
			 
			 Context connext = new InitialContext();
			 
			 DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			 
			 Connection connection = dataSource.getConnection();
			 
			 String sql="select * from users where id=?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setInt(1, id);
			
			 resultSet =preparedStatement.executeQuery();
			 
		
			//List<String> list = new ArrayList<String>();
			while(resultSet.next()){
				Users users =new Users();
				users.setStudentId(id);
				users.setName(resultSet.getString(2));
				users.setPassword(resultSet.getString(3));
				users.setNickName(resultSet.getString(4));
				users.setSex(resultSet.getString(6));
				users.setPic(resultSet.getString(8));
				users.setToken(resultSet.getString(9));
				users.setIsFistLogin(resultSet.getInt(11));
				
				return users;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(connection!=null)
					connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public String findTokenByUsername(String username){
		try {
			 
			 Context connext = new InitialContext();
			 
			 DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			 
			 Connection connection = dataSource.getConnection();
			 
			 String sql="select token from users where username=?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, username);
			
			 resultSet =preparedStatement.executeQuery();
			 
		
			//List<String> list = new ArrayList<String>();
			while(resultSet.next()){
				
				return resultSet.getString(9);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(connection!=null)
					connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	
	public Users findUserByToken (String token){
		try {
			
			 Context connext = new InitialContext();
			 
			 DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			 
			 Connection connection = dataSource.getConnection();
			 
			 String sql="select * from users where token =?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, token);
			
			
			resultSet =preparedStatement.executeQuery();
			 
		
			//List<String> list = new ArrayList<String>();
			Users users = new Users();
			while(resultSet.next()){
				users.setStudentId(resultSet.getInt(1));
				users.setName(resultSet.getString(2));
				users.setPassword(resultSet.getString(3));
				users.setNickName(resultSet.getString(4));
				users.setSex(resultSet.getString(6));
				users.setPic(resultSet.getString(8));
				users.setToken(resultSet.getString(9));
				users.setIsFistLogin(resultSet.getInt(11));
			}
			
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(connection!=null)
					connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public Users findUserByUsername(String username){
		try {
			
			 Context connext = new InitialContext();
			 
			 DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			 
			 Connection connection = dataSource.getConnection();
			 
			 String sql="select * from users where username =?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, username);
			
			
			resultSet =preparedStatement.executeQuery();
			 
		
			//List<String> list = new ArrayList<String>();
			Users users = new Users();
			while(resultSet.next()){
				users.setStudentId(resultSet.getInt(1));
				users.setName(resultSet.getString(2));
				users.setPassword(resultSet.getString(3));
				users.setNickName(resultSet.getString(4));
				users.setSex(resultSet.getString(6));
				users.setPic(resultSet.getString(8));
				users.setToken(resultSet.getString(9));
				users.setIsFistLogin(resultSet.getInt(11));
			}
			
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(connection!=null)
					connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public boolean updateToken (Users users){
		try {
			
			SecureRandom  secureRandom = SecureRandom.getInstance("SHA1PRNG");
			int random = secureRandom.nextInt();
			 String token =EncryptTools.SHA256Encrypt(users.getName()+random);
			 logger.debug(token);
			 Context connext = new InitialContext();
			 
			 DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			 
			 Connection connection = dataSource.getConnection();
			 
			 String sql="update users set token=? where username=?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, token);
			 preparedStatement.setString(2, users.getName());
			
			 int  num =preparedStatement.executeUpdate();
			 
		
			//List<String> list = new ArrayList<String>();
			while(num>0){
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(connection!=null)
					connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	public boolean insertTime(java.sql.Date time,String username){
		try {
			 
			 Context connext = new InitialContext();
			 
			 DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			 
			 Connection connection = dataSource.getConnection();
			 
			 String sql="insert into users(time) values(?) where username=?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setDate(1, time);
			 preparedStatement.setString(2, username);
			
			int  num =preparedStatement.executeUpdate();
			 
		
			//List<String> list = new ArrayList<String>();
			while(num>0){
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(connection!=null)
					connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	public Date findTimeByUsername(String username){
		try {
			 
			 Context connext = new InitialContext();
			 
			 DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			 
			 Connection connection = dataSource.getConnection();
			 
			 String sql="select time from users where username=?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, username);
			
			 resultSet =preparedStatement.executeQuery();
			 
		
			//List<String> list = new ArrayList<String>();
			while(resultSet.next()){
				
				return resultSet.getDate(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(connection!=null)
					connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public  boolean login(String username,String password){
		try {
			 
			 Context connext = new InitialContext();
			 
			 DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			 
			 Connection connection = dataSource.getConnection();
			 
			 String sql="select * from users where username=? and password=?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, username);
			 preparedStatement.setString(2, password);
			 resultSet =preparedStatement.executeQuery();
			 
			
				//List<String> list = new ArrayList<String>();
				while(resultSet.next()){
					
					loginId=resultSet.getInt(1);
					return true;
				}
				
				return false;
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(connection!=null)
					connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return false;
	
	}
	public List<Users> findAll(){
		try {
			
			Context connext = new InitialContext();
			
			DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			
			Connection connection = dataSource.getConnection();
			
			String sql="select * from users";
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet =preparedStatement.executeQuery();
			
			
			List<Users> list = new ArrayList<Users>();
			while(resultSet.next()){
				Users users = new Users();
				users.setStudentId(resultSet.getInt(1));
				users.setName(resultSet.getString(2));
				users.setPassword(resultSet.getString(3));
				users.setNickName(resultSet.getString(4));
				users.setSex(resultSet.getString(6));
				users.setPic(resultSet.getString(8));
				
				list.add(users);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		return null;
	}
	
	
	public  boolean register(String username,String password,String sex,String pic){
		try {
			 
			 Context connext = new InitialContext();
			 
			 DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			 
			 Connection connection = dataSource.getConnection();
			 
			 String sql="insert into users(username,password,sex,pic) values(?,?,?,?)";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, username);
			 preparedStatement.setString(2, password);
			 preparedStatement.setString(3, sex);
			 preparedStatement.setString(4, pic);
			 int num=preparedStatement.executeUpdate();
			 
			
				//List<String> list = new ArrayList<String>();
				while(num>0){
					
					return true;
				}
				
				return false;
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(connection!=null)
					connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		return false;
	
	}
	
	public  boolean register(String username,String password){
		try {
			 
			 Context connext = new InitialContext();
			 
			 DataSource dataSource = (DataSource)connext.lookup("java:comp/env/jndi/MySQL");
			 
			 Connection connection = dataSource.getConnection();
			 
			 String sql="insert into users(username,password) values(?,?)";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, username);
			 preparedStatement.setString(2, password);
			 
			 int num=preparedStatement.executeUpdate();
			 
			
				//List<String> list = new ArrayList<String>();
				while(num>0){
					
					return true;
				}
				
				return false;
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				
				if(connection!=null)
					connection.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		return false;
	
	}
	
	
	

}


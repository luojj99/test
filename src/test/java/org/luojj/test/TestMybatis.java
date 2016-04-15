package org.luojj.test;


//注意：import static 的spring类  post  get  
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.luojj.controller.UserController;
import org.luojj.dao.UserDao;
import org.luojj.entity.User;
import org.luojj.service.IUserService;
import org.luojj.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类 ,用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath*:srping-mvc.xml",
		"classpath*:spring-mybatis.xml" })
// 用于指定配置文件所在的位置
@WebAppConfiguration
public class TestMybatis {
	private static Logger logger = Logger.getLogger(TestMybatis.class);
	// private ApplicationContext ac = null;

	 @Autowired
	 private WebApplicationContext wac;
	  
	 private MockMvc mockMvc;

	// 模拟request,response
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserController userController;

	@Autowired
	private IUserService userService;

	// @Test
	// public void test2() {
	// ac = new ClassPathXmlApplicationContext("classpath*:spring-mybatis.xml");
	// IStudentService studentService = (IStudentService)
	// ac.getBean("studentService");
	// Student student =studentService.getStudentById(1);
	// System.out.println(student);
	// }

	@Before
	public void setup() {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();
	}

	@Test
	public void testUserlogin() {
		// User user = userService.getUserById(1L);
		User user = userService.checkLogin("13800138000", "123");
		logger.info(JSON.toJSONString(user));
		System.out.println(1111111111);
	}

	@Test
	public void test_isRegistered() {
		boolean isRegistered = userService.isRegistered("13800138000");
		Assert.assertEquals(true, isRegistered);
	}

	@Test
	public void test_json() {
		String jsonString = Util.Str2Json("aaa");
		logger.info(jsonString);
	}

	@Test
	public void testNull() {
		logger.info("testNull");
		User user = userDao.selectByPrimaryKey("13800138000");
		if (user == null) {
			user = new User();
			user.setUserName("为空");
		}

		logger.info(JSON.toJSONString(user));

	}

	@Test
	public void testIsRegistered() throws Exception {
		

		logger.info(userController.isRegistered("13800138000"));
	}
	
	@Test
	public void charachterEncoding(){
		String genderString=userDao.selectByPrimaryKey("13800138000").getGender();
		assertEquals("男", genderString);
	}
	
	
	
	
	
//	@Test
//	public void testRegister(){
//		User user=userController.register("13800138001", "456");
//		logger.info(JSON.toJSONString(user));
//	}
	
	
	
	

//	 @Test    
//	    public void testLogin() {    
//	          
//	        try {
//				mockMvc.perform(get("isRegistered/{phonenNumber}","13800138000")).andExpect(status().isOk()).andDo(print());
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	    }   


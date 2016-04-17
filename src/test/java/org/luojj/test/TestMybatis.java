package org.luojj.test;


//注意：import static 的spring类  post  get  
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.json.Json;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.luojj.controller.AssetController;
import org.luojj.controller.BankController;
import org.luojj.controller.UserController;
import org.luojj.dao.UserMapper;
import org.luojj.entity.Asset;
import org.luojj.entity.BankCard;
import org.luojj.entity.User;
import org.luojj.service.IUserService;
import org.luojj.service.impl.UserServiceImpl;
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
	private UserMapper userDao;

	@Autowired
	private UserController userController;
	
	@Autowired
	private BankController bankController;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private AssetController assetController;

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
//		User user = userService.checkLogin("13800138000", "123");
//		assertEquals("13800138000", user.getPhoneNumber());
	}

	@Test
	public void test_isRegistered() {
		boolean isRegistered = userService.isRegistered("13800138000");
		Assert.assertEquals(true, isRegistered);
	}
	

	
	/**
	 * 乱码测试
	 */
	@Test
	public void charachterEncoding(){
		String genderString=userDao.selectByPrimaryKey("13800138000").getGender();
//		assertEquals("男", genderString);
	}
	
	@Test
	public void test_insertBankCard(){
//		String phoneNumber="13800138012";
//		
//		userController.choose(phoneNumber, "555");
//		BankCard bankCard = new BankCard();
//		bankCard.setBankCardNumber("77777");
//		bankCard.setPhoneNumber(phoneNumber);
//		
//		bankController.insertBankCard(bankCard, "999","441423199245");
	}
	
	@Test
	public void test_deleteBankCard(){
//		BankCard bankCard = new BankCard();
//		bankCard.setPhoneNumber("13800138012");
//		bankController.insertBankCard(bankCard, "132", "456");
//		bankController.deleteBankCard(bankCard);
		
	}
	
	@Test
	public void test_insertAsset(){
//		Asset asset = new  Asset(); 
//		asset.setPhoneNumber("13800138000");
//		
//		assetController.insertAsset(asset);
	}
	
	
	
	@Test
	public void test_updateAsset(){
		Asset asset = new  Asset(); 
		asset.setPhoneNumber("13800138000");
		BigDecimal balanceBigDecimal = new BigDecimal("30000");
		asset.setBalance(balanceBigDecimal);
		assetController.updateAsset(asset);
	}
	
	
	@Test
	public void test_selectAsset(){
		Asset asset = new  Asset(); 
		
		asset=(Asset) assetController.getAsset("13800138000");
		logger.info(JSON.toJSONString(asset));
		
	}
	
	
}
	
	
	
	
	



package org.luojj.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;  

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.luojj.controller.AssetController;
import org.luojj.controller.BankController;
import org.luojj.controller.UserController;
import org.luojj.dao.AssetMapper;
import org.luojj.dao.UserMapper;
import org.luojj.entity.Asset;
import org.luojj.entity.User;
import org.luojj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类 ,用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath*:srping-mvc.xml",
		"classpath*:spring-mybatis.xml" })
// 当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
// 记得要在XML文件中声明事务哦~~~我是采用注解的方式
@Transactional
public class TestMybatis {
	private static Logger logger = Logger.getLogger(TestMybatis.class);
	// private ApplicationContext ac = null;

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;

	

	@Autowired
	private UserMapper userDao;
	
	@Autowired
	private AssetMapper assetMapper;

	@Autowired
	private UserController userController;

	@Autowired
	private BankController bankController;

	@Autowired
	private IUserService userService;

	@Autowired
	private AssetController assetController;

	
	@Before
	public void setup() {
		// webAppContextSetup 注意上面的static import
		// webAppContextSetup 构造的WEB容器可以添加fileter 但是不能添加listenCLASS
		// WebApplicationContext context =
		// ContextLoader.getCurrentWebApplicationContext();
		// 如果控制器包含如上方法 则会报空指针
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	
//  有些单元测试你不希望回滚
//	@Test
//	@Rollback(false)
//	public void ownerId() throws Exception {
//		mockMvc.perform((get("/spring/rest/4.do"))).andExpect(status().isOk())
//				.andDo(print());
//	}

	@Test
	public void testUserRegiser() {
		 User user = userService.register("13800138888", "888888");
		 assertEquals(user.getPhoneNumber(), assetMapper.selectByPrimaryKey("13800138888").getPhoneNumber());
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
	public void charachterEncoding() {
		String genderString = userDao.selectByPrimaryKey("13800138000")
				.getGender();
//		 assertEquals("男", genderString);
	}
	
	
	
	@Test
	public void test_updateuser(){
		User user = new User();
		user.setPhoneNumber("13800138000");
		user.setGender("中");
		
		userController.updateUser(user);
	}
	
	

	@Test
	public void test_insertBankCard() {
		// String phoneNumber="13800138012";
		//		
		// userController.choose(phoneNumber, "555");
		// BankCard bankCard = new BankCard();
		// bankCard.setBankCardNumber("77777");
		// bankCard.setPhoneNumber(phoneNumber);
		//		
		// bankController.insertBankCard(bankCard, "999","441423199245");
	}

	@Test
	public void test_deleteBankCard() {
		// BankCard bankCard = new BankCard();
		// bankCard.setPhoneNumber("13800138012");
		// bankController.insertBankCard(bankCard, "132", "456");
		// bankController.deleteBankCard(bankCard);

	}

	@Test
	public void test_insertAsset() {
		// Asset asset = new Asset();
		// asset.setPhoneNumber("13800138000");
		//		
		// assetController.insertAsset(asset);
	}
	
	@Test
	public void test_updateAsset() throws Exception {
		String phonNumber ="13800138000";
		Asset asset = new Asset();
		asset.setPhoneNumber(phonNumber);
		BigDecimal balance = new BigDecimal("2000000000");
		asset.setBalance(balance);
		String jsonString=JSON.toJSONString(asset);
//		  mockMvc.perform((post("/asset/update")
//				 .param(jsonString)))
//				 .andExpect(status()
//				 .isOk())
//				 .andDo(print());  
		 mockMvc.perform(post("/asset/update")
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(jsonString))
				 .andExpect(status()
		  		 .isOk())
			     .andDo(print());  
	}

	@Test
	public void test_selectAsset() {
		Asset asset = new Asset();
		
		asset = (Asset) assetController.getAsset("13800138000");
		logger.info(JSON.toJSONString(asset));
		
	}

//	@Test
//	public void testIdUtil() {
//		Calendar a = Calendar.getInstance();
//		IdcardInfoExtractor extractor = new IdcardInfoExtractor(
//				"441423199203242713");
//		logger.info("年龄：" + (a.get(Calendar.YEAR) - extractor.getYear()));
//		logger.info("性别：" + extractor.getGender());
//	}

}

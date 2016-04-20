package org.luojj.controller;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.luojj.baseclass.BaseBean;
import org.luojj.dao.AssetMapper;
import org.luojj.dao.UserMapper;
import org.luojj.entity.User;
import org.luojj.service.impl.UserServiceImpl;
import org.luojj.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class UserControllerTest extends BaseTest {
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private AssetMapper assetMapper;
	
	@Autowired
	private UserMapper userMapper;

//	@Before
//	public void setUp() throws Exception {
//	}

//	@Test
//	public void testFixUpdateMethod() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsRegistered() {
		BaseBean baseBean=userController.isRegistered("13800138000");
		Assert.assertEquals(0, baseBean.getErrorCode());
	}

	

	@Test
	public void testRegister() {
		userController.register("13800188888", "8888888888");
		assertEquals(userMapper.selectByPrimaryKey("13800138888").getPhoneNumber(), assetMapper.selectByPrimaryKey("13800138888").getPhoneNumber());
	}

//	@Test
//	public void testUpdateUser() {
//		User user = new User();
//		user.setPhoneNumber("13800138000");
//		user.setGender("男");
//		userController.updateUser(user);
//		assertEquals("男", userMapper.selectByPrimaryKey("13800138000").getGender());
//	}

//	@Test
//	public void testGetUser() {
//		fail("Not yet implemented");
//	}

}

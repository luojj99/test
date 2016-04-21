//package org.luojj.controller;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.luojj.dao.BankCardMapper;
//import org.luojj.dao.UserMapper;
//import org.luojj.entity.BankCard;
//import org.luojj.test.BaseTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//
//public class BankControllerTest extends BaseTest{
//	
//	@Autowired
//	private UserController userController;
//	
//	@Autowired
//	private BankController bankController;
//	
//	@Autowired
//	private BankCardMapper  bankCardMapper;

//	@Before
//	public void setUp() throws Exception {
//	}

//	@Test
//	public void testInsertBankCard() {
//		 String phoneNumber="13800138000";
//		 BankCard bankCard = new BankCard();
//		 bankCard.setBankCardNumber("77777");
//		 bankCard.setBankName("平安银行");
//		 bankCard.setPhoneNumber(phoneNumber);
//		 bankController.insertBankCard(bankCard, "888", "62222");
//		 assertEquals("77777", bankCardMapper.selectByPrimaryKey(phoneNumber).getBankCardNumber());
//		 
//	}

//	@Test
//	public void testDeleteBankCard() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testSelectByPhoneNumber() {
//		fail("Not yet implemented");
//	}

//}

package org.luojj.controllertest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.luojj.controller.BankController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
//表示继承了SpringJUnit4ClassRunner类 ,用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath*:srping-mvc.xml",
		"classpath*:spring-mybatis.xml" })
public class BankControllerTest {
	@Autowired
	BankController bankController;

	@Test
	public void testInsertBankCard() {
		
//		bankController.insertBankCard(bankCardNumberInfo)
	}

	@Test
	public void testDeleteBankCard() {
		
	}

}

package org.luojj.controller;

import static org.junit.Assert.*;


import java.math.BigDecimal;
import java.util.Map;

import javax.json.Json;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.luojj.dao.InvestGroupMapper;
import org.luojj.entity.InvestGroup;
import org.luojj.entity.Order;
import org.luojj.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.alibaba.fastjson.JSON;

public class OrderControllerTest extends BaseTest{
	 private static Logger logger = Logger.getLogger(OrderControllerTest.class);  
	@Autowired
	private OrderController orderController;
	@Autowired
	private InvestGroupMapper investGroupMapper;
	@Test
	@Rollback(false)
	public void testIsertOrder() {
		Order order = new Order();
		System.out.println(1111111);
		order.setActualAmount(new BigDecimal("1000"));
		//InvestGroup investGroup = investGroupMapper.selectByPrimaryKey(146167836283331L);
		order.setInvestGroupId(146174485776731L);
		System.out.println(2222);
		order.setPaymentType("BANKCARD");
		System.out.println(33333);
		order.setPhoneNumber("13800138000");
		Map<String, Object>map=orderController.isertOrder(order);
		logger.info(JSON.toJSONString(map));
	}

}

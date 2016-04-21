package org.luojj.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.luojj.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class InvestGroupControllerTest extends BaseTest{
	@Autowired
	private InvestGroupController investGroupController;
	
	@Test
	public void testGetInvestGroup() {
		System.out.println(investGroupController.getInvestGroup("13800138000"));
	}

}

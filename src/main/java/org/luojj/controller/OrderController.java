package org.luojj.controller;

import org.luojj.dao.BondMapper;
import org.luojj.dao.FundMapper;
import org.luojj.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
	@Autowired
	private BondMapper bondMapper;
	@Autowired
	private FundMapper fundMapper;
	
	@ResponseBody
	@RequestMapping
	public Order isertOrder(Order order){
		
		return null;
	}

}

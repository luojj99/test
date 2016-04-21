package org.luojj.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.luojj.baseclass.BaseController;
import org.luojj.core.InvestGroup;
import org.luojj.core.InvestSystem;
import org.luojj.dao.BondMapper;
import org.luojj.dao.FundMapper;
import org.luojj.dao.StockMapper;
import org.luojj.dao.UserMapper;
import org.luojj.entity.Bond;
import org.luojj.entity.Fund;
import org.luojj.entity.Stock;
import org.luojj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class InvestGroupController extends BaseController {
	private static Logger logger = Logger
			.getLogger(InvestGroupController.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private StockMapper stockMapper;
	@Autowired
	private FundMapper fundMapper;
	@Autowired
	private BondMapper bondMapper;

	@ResponseBody
	@RequestMapping(value = "/investgroup/select/{phoneNumber}", method = RequestMethod.GET)
	public Map<String, Object> getInvestGroup(@PathVariable String phoneNumber) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User user = userMapper.selectByPrimaryKey(phoneNumber);
			System.out.println(1);
			if (user!=null) {
				map=getInvestGroup22(phoneNumber);
				return map;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(3);
		map.put("errorCode", 1);
		return map;
	}
	
	
	public Map<String, Object> getInvestGroup22(String phoneNumber){
		
		System.out.println(11);
		Map<String, Object> map = new HashMap<String, Object>();
		User user= userMapper.selectByPrimaryKey(phoneNumber);
		System.out.println(22);
		InvestSystem.recommend(user);
		Stock stock=stockMapper.selectByPrimaryKey(11L);
		stock.setInvestRate(InvestSystem.STOCK_RATIO);
		System.out.println(33);
		Bond bond =bondMapper.selectByPrimaryKey(31L);;
		bond.setInvestRate(InvestSystem.BOND_RATIO);
		Fund fund =fundMapper.selectByPrimaryKey(21L);
		fund.setInvestRate(InvestSystem.FUND_RATIO);
		System.out.println(44);
		map.put("bond", bond);
		map.put("fund", fund);
		map.put("stock", stock);
		map.put("phoneNumber", phoneNumber);
		logger.info(JSON.toJSONString(map));
		logger.info("stock ratio:"+stock.getInvestRate());
		logger.info("fund ratio:"+fund.getInvestRate());
		logger.info("bond ratio:"+bond.getInvestRate());
		
		return map;
	}
	
	
	

}

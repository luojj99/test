package org.luojj.core;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import org.apache.log4j.Logger;
import org.luojj.controller.TradingRecordController;
import org.luojj.dao.BondMapper;
import org.luojj.dao.FundMapper;
import org.luojj.dao.StockMapper;
import org.luojj.dao.UserMapper;
import org.luojj.entity.Bond;
import org.luojj.entity.Fund;
import org.luojj.entity.Stock;
import org.luojj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
@Entity
public class InvestGroup {
	private static Logger logger = Logger.getLogger(InvestGroup.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private FundMapper fundMapper;
	@Autowired
	private BondMapper bondMapper;
	@Autowired
	private StockMapper stockMapper;
	private Stock stock;
	private Fund fund;
	private Bond bond;
	private String phoneNumber;
	
	
	
	public Map<String, Object> getInvestGroup(String phoneNumber){
		this.phoneNumber=phoneNumber;
		System.out.println(11);
		Map<String, Object> map = new HashMap<String, Object>();
		User user= userMapper.selectByPrimaryKey(phoneNumber);
		System.out.println(22);
		chooseGroup();
		InvestSystem.recommend(user);
		stock.setInvestRate(InvestSystem.STOCK_RATIO);
		System.out.println(33);
		bond.setInvestRate(InvestSystem.BOND_RATIO);
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
	
	
	public void chooseGroup(){
		 this.stock = stockMapper.selectByPrimaryKey(11L);
	      this.bond = bondMapper.selectByPrimaryKey(31L);
	      this.fund = fundMapper.selectByPrimaryKey(21L);
	}
	
	public void calAverageRate(){
		
		
	}
	

}

package org.luojj.controller;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.luojj.baseclass.BaseController;
import org.luojj.core.InvestSystem;
import org.luojj.dao.AssetMapper;
import org.luojj.dao.BondMapper;
import org.luojj.dao.FundMapper;
import org.luojj.dao.InvestGroupMapper;
import org.luojj.dao.StockMapper;
import org.luojj.dao.UserMapper;
import org.luojj.entity.Asset;
import org.luojj.entity.Bond;
import org.luojj.entity.Fund;
import org.luojj.entity.InvestGroup;
import org.luojj.entity.Stock;
import org.luojj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	@Autowired
	private AssetController assetController;
	@Autowired
	private AssetMapper assetMapper;
	@Autowired
	private InvestGroupMapper investGroupMapper;

	@ResponseBody
	@RequestMapping(value = "/investgroup/select/{phoneNumber}", method = RequestMethod.GET)
	public Map<String, Object> getInvestGroup(@RequestBody String phoneNumber) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User user = userMapper.selectByPrimaryKey(phoneNumber);
			System.out.println(1);
			if (user!=null) {
				InvestGroup investGroup = investGroupMapper.getLatestInvestGroup(phoneNumber);
				if (investGroup==null) {
					map=createInvestGroup(phoneNumber);
				}else{
					map=getLatestInvestGroup(phoneNumber);
				}
					map.put("errorCode", 0);
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
	
	
	public Map<String, Object> getLatestInvestGroup(String phoneNumber){
		Map<String, Object> map = new HashMap<String, Object>();
		
		InvestGroup investGroup = investGroupMapper.getLatestInvestGroup(phoneNumber);
		Bond bond = bondMapper.selectByPrimaryKey(investGroup.getLowRiskId());
		Stock stock = stockMapper.selectByPrimaryKey(investGroup.getHighRiskId());
		Fund fund = fundMapper.selectByPrimaryKey(investGroup.getMiddleRiskId());
		map.put("bond", bond);
		map.put("fund", fund);
		map.put("stock", stock);
		map.put("phoneNumber", phoneNumber);
		return map;
	}
	
	
	
	
	
	
	public Map<String, Object> createInvestGroup(String phoneNumber){
		
		System.out.println(11);
		Map<String, Object> map = new HashMap<String, Object>();
		User user= userMapper.selectByPrimaryKey(phoneNumber);
		System.out.println(22);
		
		InvestSystem.recommend(user);
		//选择高中低风险型产品并设置比例
		Stock stock=stockMapper.selectByPrimaryKey(11L);
		stock.setInvestRate(InvestSystem.STOCK_RATIO);
		System.out.println(33);
		Bond bond =bondMapper.selectByPrimaryKey(31L);;
		System.out.println(33.0);
		bond.setInvestRate(InvestSystem.BOND_RATIO);
		Fund fund =fundMapper.selectByPrimaryKey(21L);
		fund.setInvestRate(InvestSystem.FUND_RATIO);
		System.out.println(fund.getInvestRate());
		
		//计算收益
		System.out.println(33.1);
		BigDecimal fundProfit=fund.getChangeRate().multiply(fund.getFundPrice());
		System.out.println(33.001);
		BigDecimal bondProfit=bond.getChangeRate().multiply(bond.getBondPrice());
		BigDecimal stockProfit=stock.getChangeRate().multiply(stock.getStockPrice());
		BigDecimal groupProfit=fundProfit.add(bondProfit).add(stockProfit);
		System.out.println(33.2);
		InvestGroup investGroup = new InvestGroup();
		investGroup.setLowRiskId(bond.getProductId());
		investGroup.setLowRiskRatio(InvestSystem.BOND_RATIO);
		investGroup.setMiddleRiskId(fund.getProductId());
		investGroup.setMiddleRiskRatio(InvestSystem.FUND_RATIO);
		investGroup.setHighRiskId(stock.getProductId());
		investGroup.setHighRiskRatio(InvestSystem.STOCK_RATIO);
		investGroup.setGroupProfit(groupProfit);
		System.out.println(33.3);
		investGroup.setPhoneNumber(phoneNumber);
		investGroup.setInvestGroupId(Long.parseLong(System.currentTimeMillis()+""+bond.getProductId()));
		investGroup.setIsRecommend(1);
		
		//插入到推荐组合
		investGroupMapper.insert(investGroup);
		System.out.println(44);
		map.put("bond", bond);
		map.put("fund", fund);
		map.put("stock", stock);
		map.put("phoneNumber", phoneNumber);
		logger.info(JSON.toJSONString(map));
		logger.info("stock ratio:"+stock.getInvestRate());
		logger.info("fund ratio:"+fund.getInvestRate());
		logger.info("bond ratio:"+bond.getInvestRate());
		logger.info("investGroup:"+JSON.toJSONString(investGroup));
		return map;
	}
	
	
	
	
	
	
	

}

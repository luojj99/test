package org.luojj.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.luojj.controller.AssetController;
import org.luojj.dao.BondMapper;
import org.luojj.dao.FundMapper;
import org.luojj.dao.InvestGroupMapper;
import org.luojj.dao.StockMapper;
import org.luojj.entity.Bond;
import org.luojj.entity.Fund;
import org.luojj.entity.InvestGroup;
import org.luojj.entity.Stock;
import org.luojj.service.IInvestGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestGroupServiceImpl  implements IInvestGroupService{
	 private static Logger logger = Logger.getLogger(InvestGroupServiceImpl.class);  
	@Autowired
	private InvestGroupMapper investGroupMapper;
	@Autowired
	private FundMapper fundMapper;
	@Autowired
	private BondMapper bondMapper;
	@Autowired
	private StockMapper stockMapper;
	
	public BigDecimal getGroupProfit(InvestGroup investGroup) {
		// TODO Auto-generated method stub
		Fund fund = fundMapper.selectByPrimaryKey(investGroup.getMiddleRiskId());
		Bond bond =bondMapper.selectByPrimaryKey(investGroup.getLowRiskId());
		Stock stock = stockMapper.selectByPrimaryKey(investGroup.getHighRiskId());
		BigDecimal fundProfit=fund.getChangeRate().multiply(fund.getFundPrice());
		BigDecimal bondProfit=bond.getChangeRate().multiply(bond.getBondPrice());
		BigDecimal stockProfit=stock.getChangePrice().multiply(stock.getStockPrice());
		BigDecimal groupProfit=fundProfit.add(bondProfit).add(stockProfit);
		logger.info("groupProfit:"+groupProfit);
		return groupProfit;
	}
	
//	public static void main(String []arg0){
//		InvestGroupServiceImpl investGroupServiceImpl = new InvestGroupServiceImpl();
//		System.out.println(investGroupServiceImpl.getGroupProfit(investGroup));
//	}

	public InvestGroup getInvestGroup(Long investGroupId) {
		// TODO Auto-generated method stub
		
		return investGroupMapper.selectByPrimaryKey(investGroupId);
	}

	public List<InvestGroup> getInvestGroupList(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}

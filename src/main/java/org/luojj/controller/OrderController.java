package org.luojj.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import org.luojj.baseclass.BaseController;
import org.luojj.dao.AssetMapper;
import org.luojj.dao.BondMapper;
import org.luojj.dao.FundMapper;
import org.luojj.dao.InvestGroupMapper;
import org.luojj.dao.OrderMapper;
import org.luojj.dao.StockMapper;
import org.luojj.dao.TradingRecordMapper;
import org.luojj.entity.Asset;
import org.luojj.entity.Bond;
import org.luojj.entity.Fund;
import org.luojj.entity.InvestGroup;
import org.luojj.entity.Order;
import org.luojj.entity.Stock;
import org.luojj.entity.TradingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class OrderController extends BaseController{
	private static Logger logger = Logger.getLogger(OrderController.class);  
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private InvestGroupMapper investGroupMapper;
	@Autowired
	private BondMapper bondMapper;
	@Autowired
	private FundMapper fundMapper;
	@Autowired
	private StockMapper stockMapper;
	@Autowired
	private TradingRecordMapper tradingRecordMapper;
	@Autowired
	private AssetMapper assetMapper;
	@Autowired
	private InvestGroupController investGroupController;
	
	@ResponseBody
	@RequestMapping(value="/order/insert",method=RequestMethod.POST)
	public Map<String, Object> isertOrder(@RequestBody Order order){
		Map<String, Object>map =new HashMap<String, Object>();
		order.setOrderId(System.currentTimeMillis());
		InvestGroup investGroup = investGroupMapper.selectByPrimaryKey(order.getInvestGroupId());
		BigDecimal orderAmount =order.getActualAmount();
		Bond bond = bondMapper.selectByPrimaryKey(investGroup.getLowRiskId());
		Fund fund = fundMapper.selectByPrimaryKey(investGroup.getMiddleRiskId());
		Stock stock =stockMapper.selectByPrimaryKey(investGroup.getHighRiskId());
		
		//统计订单收益
		System.out.println(1);
//		InvestGroupController investGroupController = new InvestGroupController();
		investGroupController.getNewInvestGroup(order.getPhoneNumber());
		BigDecimal bondProfit=bond.getInvestRate().multiply(bond.getChangePrice()).multiply(orderAmount).divide(bond.getBondPrice(),10,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal fundProfit=fund.getInvestRate().multiply(fund.getChangePrice()).multiply(orderAmount).divide(fund.getFundPrice(),10,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal stockProfit=stock.getInvestRate().multiply(stock.getChangePrice()).multiply(orderAmount).divide(stock.getStockPrice(),10,BigDecimal.ROUND_HALF_DOWN);
	    BigDecimal yesterdayProfit=bondProfit.add(fundProfit).add(stockProfit);
	    System.out.println(2);
	    order.setYesterdayProfit(yesterdayProfit);
	    System.out.println(2.1);
	    BigDecimal totalProfit=order.getTotalProfit();
	    System.out.println(2.2);
//	    BigDecimal totalProfitBigDecimal=totalProfitBigDecimal.add(yesterdayProfit);
	    System.out.println(2.3);
	    if (totalProfit==null) {
	    	 order.setTotalProfit(yesterdayProfit);
		}else {
			 totalProfit=totalProfit.add(yesterdayProfit);
			   order.setTotalProfit(totalProfit);
		}
	   
	    System.out.println(2.4);
		orderMapper.insert(order);
		System.out.println(3);
		//插入总交易记录
		TradingRecord tradingRecord = new TradingRecord();
		System.out.println(3.1);
		tradingRecord.setTradingAmount(orderAmount);
		System.out.println(3.2);
		tradingRecord.setTradingType("LCGM");
		System.out.println(3.3);
		tradingRecord.setTradingRecordId(Long.parseLong(System.currentTimeMillis()+order.getPhoneNumber().substring(6,10)));
		System.out.println(4);
		//更新资产
		Asset asset = assetMapper.selectByPrimaryKey(order.getPhoneNumber());
		BigDecimal totalAsset=asset.getTotalAsset();
		if (order.getPaymentType().equals("BANKCARD")) {
			System.out.println(4.1);
			//更新总资产
			totalAsset=totalAsset.add(order.getActualAmount());
			asset.setTotalAsset(totalAsset);
			System.out.println(5);
		}else if (order.getPaymentType().equals("BALANCE")) {
			BigDecimal balance=asset.getBalance();
			balance=balance.subtract(orderAmount);
			int i=balance.compareTo(BigDecimal.ZERO); 
			if (i>=0) {
				asset.setBalance(balance);
				System.out.println(4.3);
			}else{
				System.out.println(4.4);
				map.put("errorCode", 1);
				map.put("message", "lack of balance");
				return map;
			}
			System.out.println(6);
		}
		updateAsset4Order(asset, order);
		assetMapper.updateByPrimaryKey(asset);
		
		System.out.println(7);
		logger.info("asset:"+JSON.toJSONString(asset));
		logger.info("order:"+JSON.toJSONString(order));
		
		
		map.put("order", order);
		map.put("errorCode", 0);
		return map;
	}
	
	/**
	 * 每日更新总收益和总资产和昨日收益
	 * @param asset
	 * @param order
	 */
	public void updateAsset4Order(Asset asset,Order order){
		//每日更新昨日收益
		
		BigDecimal yesterdayProfit=order.getTotalProfit();
		asset.setYesterdayProfit(yesterdayProfit);
		//每日更新总收益
		BigDecimal totalProfit=asset.getTotalProfit();
		asset.setTotalProfit(totalProfit.add(asset.getYesterdayProfit()));
		
		//每日更新总资产
		BigDecimal totalAsset = asset.getTotalAsset();
		asset.setTotalAsset(totalAsset.add(asset.getYesterdayProfit()));
		
		//assetMapper.updateByPrimaryKey(asset);
		
	}

}

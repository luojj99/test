package org.luojj.controller;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.luojj.dao.AssetMapper;
import org.luojj.dao.InvestGroupMapper;
import org.luojj.dao.TradingRecordMapper;
import org.luojj.entity.TradingRecord;
import org.luojj.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.alibaba.fastjson.JSON;

public class TradingRecordControllerTest extends BaseTest{
	private static Logger logger = Logger.getLogger(TradingRecordControllerTest.class);  
	@Autowired
	private TradingRecordController tradingRecordController;
	@Autowired
	private AssetMapper assetMapper;
	@Autowired
	private TradingRecordMapper tradingRecordMapper;

	@Test
	public void testInsertRecord() {
		String phoneNumber ="13800138000";
		BigDecimal addaount= new BigDecimal("10");
		//插入前balance
		BigDecimal balanceBefore=assetMapper.selectByPrimaryKey(phoneNumber).getBalance();
		
		TradingRecord tradingRecord = new TradingRecord();
		tradingRecord.setPhoneNumber(phoneNumber);
		tradingRecord.setTradingType("CZ");
		tradingRecord.setTradingAmount(addaount);
		tradingRecordController.insertRecord(tradingRecord);
		
		assertEquals(balanceBefore.add(addaount), assetMapper.selectByPrimaryKey(phoneNumber).getBalance());
	}
//	
//	@Test
//	public void testGetRecordList() {
//		tradingRecordController.getRecordList("13512300001");
//	}
//	
	@Test
	public void testGetRecordList(){
		String jsonString=JSON.toJSONString(tradingRecordController.getCZRecord("13800138000"));
		logger.info("充值列表："+jsonString);
		
		String jsonString2=JSON.toJSONString(tradingRecordController.getTXRecord("13800138000"));
		logger.info("提现列表："+jsonString2);
		
		String jsonString3=JSON.toJSONString(tradingRecordController.getLCGMRecord("13800138000"));
		logger.info("理财购买列表："+jsonString3);
	}
	
	
	

}

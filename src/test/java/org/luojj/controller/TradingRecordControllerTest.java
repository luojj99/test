package org.luojj.controller;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.luojj.entity.TradingRecord;
import org.luojj.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.alibaba.fastjson.JSON;

public class TradingRecordControllerTest extends BaseTest{
	private static Logger logger = Logger.getLogger(TradingRecordControllerTest.class);  
	@Autowired
	private TradingRecordController tradingRecordController;

	@Test
	@Rollback(false)
	public void testInsertRecord() {
		String phoneNumber ="13800138000";
		TradingRecord tradingRecord = new TradingRecord();
		tradingRecord.setPhoneNumber(phoneNumber);
		tradingRecord.setTradingType("充值");
		tradingRecord.setTradingAmount(new BigDecimal("222"));
		logger.info("："+JSON.toJSONString(tradingRecord));
		tradingRecordController.insertRecord(tradingRecord);
	}
	
	@Test
	public void testGetRecordList() {
	}

}

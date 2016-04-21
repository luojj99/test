package org.luojj.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.luojj.baseclass.BaseBean;
import org.luojj.baseclass.BaseController;
import org.luojj.dao.AssetMapper;
import org.luojj.dao.TradingRecordMapper;
import org.luojj.dao.UserMapper;
import org.luojj.entity.Asset;
import org.luojj.entity.TradingRecord;
import org.luojj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping("/record")
public class TradingRecordController extends BaseController{
	private static Logger logger = Logger.getLogger(TradingRecordController.class);  
	@Autowired
	private TradingRecordMapper tradingRecordMapper;
	@Autowired
	private AssetMapper assetMapper;
	@Autowired
	private UserMapper userMapper;
	
	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.POST,headers={"content-type=application/json","content-type=application/xml"})
	public BaseBean insertRecord(@RequestBody TradingRecord tradingRecord
			){
		try {
			logger.info("tradingRecord:"+JSON.toJSONString(tradingRecord));
			Asset asset= assetMapper.selectByPrimaryKey(tradingRecord.getPhoneNumber());
			logger.info("asset update before:"+JSON.toJSONString(asset));
			String type=tradingRecord.getTradingType();
			//类型：充值CZ、提现TX、理财购买、理财变现、理财到期转出LCDQZC
			if (asset!=null) {
				logger.info("asset!=null");
				BigDecimal tradingAmount=tradingRecord.getTradingAmount();
				BigDecimal balance= asset.getBalance();
				if (type.equals("CZ")||type.equals("LCDQZC")) {
					logger.info("type.equals('CZ')||type.equals('LCDQZC')");
					if (type.equals("CZ")) {
						tradingRecord.setTradingType("充值");
					}
					if (type.equals("LCDQZC")) {
						tradingRecord.setTradingType("理财到期转出");
					}
					balance=balance.add(tradingAmount);
				}else if (type.equals("TX")) {
					logger.info("type.equals(TX)");
					if (type.equals("TX")) {
						tradingRecord.setTradingType("提现");
					}
					balance=balance.subtract(tradingAmount);
				}
				if (type.equals("CZ")||type.equals("LCDQZC")||type.equals("TX")) {
					asset.setBalance(balance);
					assetMapper.updateByPrimaryKey(asset);
					tradingRecord.setTradingRecordId(Long.parseLong(System.currentTimeMillis()+tradingRecord.getPhoneNumber().substring(6,10)));
					tradingRecordMapper.insert(tradingRecord);
					logger.info("asset update after："+JSON.toJSONString(assetMapper.selectByPrimaryKey(tradingRecord.getPhoneNumber())));
					return SUCCESS(null, tradingRecord);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return FAIL("insertRecord FAIL");
	}
	
	@ResponseBody
	@RequestMapping(value="/getRecordList/{phoneNumber}",method=RequestMethod.GET)
	public Map<String, Object> getRecordList(@PathVariable String phoneNumber){
		Map<String, Object>map= new HashMap<String, Object>();
		List<TradingRecord> recordList =  new ArrayList<TradingRecord>();
		try {
			User user = userMapper.selectByPrimaryKey(phoneNumber);
			if (user!=null) {
				recordList =tradingRecordMapper.getRecordListByPhoneNo(phoneNumber);
				map.put("recordList", recordList);
				map.put("errorCode", 0);
				return map;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		map.put("errorCode", 1);
		return map;
	}

}

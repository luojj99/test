package org.luojj.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.luojj.baseclass.BaseBean;
import org.luojj.baseclass.BaseController;
import org.luojj.dao.AssetMapper;
import org.luojj.dao.TradingRecordMapper;
import org.luojj.entity.Asset;
import org.luojj.entity.TradingRecord;
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
	
	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.POST,headers={"content-type=application/json","content-type=application/xml"})
	public BaseBean insertRecord(@RequestBody TradingRecord tradingRecord
			){
		try {
			logger.info("交易记录提交："+JSON.toJSONString(tradingRecord));
			Asset asset= assetMapper.selectByPrimaryKey(tradingRecord.getPhoneNumber());
			logger.info("提交前余额："+JSON.toJSONString(asset));
			String type=tradingRecord.getTradingType();
			//充值、提现、理财到期转出
			if (asset!=null) {
				
				BigDecimal tradingAmount=tradingRecord.getTradingAmount();
				BigDecimal balance= asset.getBalance();
				if (type.equals("充值")||type.equals("理财到期转出")) {
					balance=balance.add(tradingAmount);
				}else if (type.equals("提现")) {
					balance=balance.subtract(tradingAmount);
				}
				asset.setBalance(balance);
				assetMapper.updateByPrimaryKey(asset);
				tradingRecord.setTradingRecordId(Long.parseLong(System.currentTimeMillis()+tradingRecord.getPhoneNumber().substring(6,10)));
				tradingRecordMapper.insert(tradingRecord);
				logger.info("提交后余额："+JSON.toJSONString(assetMapper.selectByPrimaryKey(tradingRecord.getPhoneNumber())));
				return SUCCESS(null, tradingRecord);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return FAIL("insertRecord fail");
	}
	
	@ResponseBody
	@RequestMapping(value="/getRecordList/{phoneNumber}",method=RequestMethod.GET)
	public List<TradingRecord> getRecordList(@PathVariable String phoneNumber){
		List<TradingRecord> cardList =  new ArrayList<TradingRecord>();
		try {
			cardList =tradingRecordMapper.getRecordListByPhoneNo(phoneNumber);
			return cardList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}

package org.luojj.controller;



import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.luojj.baseclass.BasicObject;
import org.luojj.dao.BankCardDao;


import org.luojj.entity.BankCard;

import org.luojj.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/bankCard")
public class BankController extends BasicController{
	private static Logger logger = Logger.getLogger(BankController.class);  
	@Autowired
	private BankCardDao bankCardDao;
	
	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insertBankCard(@ModelAttribute BankCard bankCard){
		
		int status=bankCardDao.insert(bankCard);
		if (status==1) {
			 logger.info("insert success");
			 return Util.Str2Json("insert success");
		}
		logger.info("insert fail");
		return Util.Str2Json("insert fail");
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteBankCard(@ModelAttribute BankCard bankCard){
		int status= bankCardDao.deleteByPrimaryKey(bankCard.getPhoneNumber());
		
		if (status==1) {
			logger.info("delete success");
			return Util.Str2Json("delete success");
		}else{
			logger.info("delete fail");
			return Util.Str2Json("delete fail");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/select/{phoneNumber}",method=RequestMethod.GET)
	public BasicObject selectByPhoneNumber(@PathVariable String phoneNumber){
		BankCard bankCard = bankCardDao.selectByPrimaryKey(phoneNumber);
		if (bankCard==null) {
			return  FAIL("bankcard null");
		}
		SUCCESS(bankCard);
		logger.info(JSON.toJSONString(bankCard));
		return bankCard;
	}
}

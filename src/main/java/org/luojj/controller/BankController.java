package org.luojj.controller;

import org.apache.log4j.Logger;
import org.luojj.dao.BankCardDao;


import org.luojj.entity.BankCard;

import org.luojj.util.JsonUtil;
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
public class BankController {
	private static Logger logger = Logger.getLogger(BankController.class);  
	@Autowired
	private BankCardDao bankCardDao;
	
	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insertBankCard(@ModelAttribute BankCard bankCard){
		
		int status=bankCardDao.insert(bankCard);
		if (status==1) {
			 logger.info("insert success");
			 return JsonUtil.msg2Json("insert success");
		}
		logger.info("insert fail");
		return JsonUtil.msg2Json("insert fail");
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteBankCard(@ModelAttribute BankCard bankCard){
		int status= bankCardDao.deleteByPrimaryKey(bankCard.getPhoneNumber());
		
		if (status==1) {
			logger.info("delete success");
			return JsonUtil.msg2Json("delete success");
		}else{
			logger.info("delete fail");
			return JsonUtil.msg2Json("delete fail");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/select/{phoneNumber}",method=RequestMethod.GET)
	public BankCard selectByPhoneNumber(@PathVariable String phoneNumber){
		logger.info(JSON.toJSONString(bankCardDao.selectByPrimaryKey(phoneNumber)));
		return bankCardDao.selectByPrimaryKey(phoneNumber);
	}
}

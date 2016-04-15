package org.luojj.controller;



import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.luojj.baseclass.BasicObject;
import org.luojj.dao.BankCardDao;
import org.luojj.dao.UserDao;


import org.luojj.entity.BankCard;
import org.luojj.entity.User;

import org.luojj.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/bankCard")
public class BankController extends BasicController{
	private static Logger logger = Logger.getLogger(BankController.class);  
	@Autowired
	private BankCardDao bankCardDao;
	@Autowired
	private UserDao userDao;
	
	
	/**
	 * 触发器insertBankCardNumber：插入银行卡的时候同时在user_info插入卡号
	 * @param bankCard
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public BasicObject insertBankCard(@ModelAttribute BankCard bankCard,
			@RequestParam(value="tradingPassword") String tradingPassword,
			@RequestParam(value="idCardNumber") String idCardNumber){
		try {
			int status=bankCardDao.insert(bankCard);
			User user=userDao.selectByPrimaryKey(bankCard.getPhoneNumber());
			user.setTradingPassword(tradingPassword);
			user.setRealName(bankCard.getRealName());
			user.setIdCardNumber(idCardNumber);
			int status2=userDao.updateByPrimaryKey(user);
			if (status==1&&user!=null&&status2==1) {
				
				return SUCCESS("insert success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return FAIL("insert fail");
		
	}
	
	@ModelAttribute
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public BasicObject deleteBankCard( BankCard bankCard){
		try {
			int status= bankCardDao.deleteByPrimaryKey(bankCard.getPhoneNumber());
			
			if (status==1) {
				logger.info("delete success");
				return SUCCESS("delete success");
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		logger.info("delete fail");
		return FAIL("delete fail");
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

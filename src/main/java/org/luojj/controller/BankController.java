package org.luojj.controller;



import java.util.Calendar;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.luojj.baseclass.BaseController;
import org.luojj.baseclass.BaseBean;
import org.luojj.dao.BankCardMapper;
import org.luojj.dao.UserMapper;


import org.luojj.entity.BankCard;
import org.luojj.entity.User;

import org.luojj.util.IdcardInfoExtractor;
import org.luojj.util.IdcardValidator;
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
public class BankController extends BaseController{
	private static Logger logger = Logger.getLogger(BankController.class);  
	@Autowired
	private BankCardMapper bankCardMapper;
	@Autowired
	private UserMapper userMapper;
	
	
	/**
	 * 触发器insertBankCardNumber：插入银行卡的时候同时在user_info插入卡号
	 * 删除银行卡同时删除user_info卡号
	 * @param bankCard
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public BaseBean insertBankCard(@ModelAttribute BankCard bankCard,
			@RequestParam(value="tradingPassword") String tradingPassword,
			@RequestParam(value="idCardNumber") String idCardNumber){
		try {
			User user=userMapper.selectByPrimaryKey(bankCard.getPhoneNumber());
			if (user!=null) {
				
				user.setTradingPassword(tradingPassword);
				user.setRealName(bankCard.getRealName());
				user.setIdCardNumber(idCardNumber);
				IdcardValidator validator = new IdcardValidator();
				boolean isIdcardValid = validator.isValidatedAllIdcard(idCardNumber);
				if (isIdcardValid) {
					Calendar a=Calendar.getInstance();
					IdcardInfoExtractor extractor = new IdcardInfoExtractor(idCardNumber);
					user.setAge(a.get(Calendar.YEAR)-extractor.getYear());
					user.setGender(extractor.getGender());
					logger.info("年龄："+(a.get(Calendar.YEAR)-extractor.getYear()));
				}
				int status=bankCardMapper.insert(bankCard);
				int status2=userMapper.updateByPrimaryKey(user);
				
				if (status==1&&user!=null&&status2==1) {
					return SUCCESS("insert success:",user);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return FAIL("insert fail");
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public BaseBean deleteBankCard(@ModelAttribute BankCard bankCard){
		try {
			int status= bankCardMapper.deleteByPrimaryKey(bankCard.getPhoneNumber());
			
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
	public BaseBean selectByPhoneNumber(@PathVariable String phoneNumber){
		BankCard bankCard = bankCardMapper.selectByPrimaryKey(phoneNumber);
		if (bankCard==null) {
			return  FAIL("bankcard null");
		}
		SUCCESS(null, bankCard);
		logger.info(JSON.toJSONString(bankCard));
		return bankCard;
	}
}

package org.luojj.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.luojj.baseclass.BaseController;
import org.luojj.dao.BondMapper;
import org.luojj.dao.FundMapper;
import org.luojj.entity.Bond;
import org.luojj.entity.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class InvestGroupController extends BaseController{
	private static Logger logger = Logger.getLogger(InvestGroupController.class);  
	@Autowired
	private BondMapper bondMapper;
	@Autowired
	private FundMapper fundMapper;
	
	@ResponseBody
	@RequestMapping(value="/investgroup/select/{phoneNumber}",method=RequestMethod.GET)
	public Map<String, Object> getInvestGroup(@PathVariable String phoneNumber){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Bond bond = bondMapper.selectByPrimaryKey(31L);
			Fund fund = fundMapper.selectByPrimaryKey(21L);
			map.put("bond", bond);
			map.put("fund", fund);
			map.put("errorCode", 0);
			map.put("phoneNumber", phoneNumber);
			logger.info(JSON.toJSONString(map));
			return map;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		map.put("errorCode", 1);
		return map;
	}

}

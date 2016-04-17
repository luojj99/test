package org.luojj.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.luojj.baseclass.BaseBean;
import org.luojj.baseclass.BaseController;
import org.luojj.dao.AssetMapper;
import org.luojj.entity.Asset;
import org.luojj.entity.BankCard;
import org.luojj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;


@Controller
public class AssetController extends BaseController{
	 private static Logger logger = Logger.getLogger(AssetController.class);  
	 
	 @Autowired
	 private AssetMapper assetMapper;
	
	/** 
	 *  解决部分更新问题
	 *  有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!  
	 *  该方法会从数据库拉取数据，然后放在map中，springmvc就会把从参数获取得到的bean也添加到map中，
	 *  把从参数获取得到的bean的空字段和拉取的bean合并
	 */  
	@ModelAttribute  
	public void fixUpdateMethod(@RequestParam(value="phoneNumber",required=false) String phoneNumber,   
	        Map<String, Object> map){  
	    logger.info("modelAttribute method");  
	    if(phoneNumber != null){  
	        Asset asset=assetMapper.selectByPrimaryKey(phoneNumber);
	        map.put("asset", asset);  
	    }  
	}  
	
	
	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public BaseBean insertAsset(@ModelAttribute Asset asset){
		try {
			int status=assetMapper.insert(asset);
			if (status==1) {
				return SUCCESS("insert success");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return FAIL("insert fail");
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="asset/update",method=RequestMethod.POST)
	public BaseBean updateAsset(@ModelAttribute Asset asset){
		try {
    		int status=assetMapper.updateByPrimaryKey(asset);
        	if (status==1) {
    			return SUCCESS("update success");
    		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return FAIL("update fail");
	}
	
	
	@ResponseBody
    @RequestMapping(value="/asset/select/{phoneNumber}",method=RequestMethod.GET)
    public BaseBean getAsset(@PathVariable String phoneNumber){
		try {
			Asset asset =  assetMapper.selectByPrimaryKey(phoneNumber);
			return SUCCESS(asset);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return FAIL("select fail");
		}
    }
	
}

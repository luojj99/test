package org.luojj.controller;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.luojj.entity.Asset;
import org.luojj.test.BaseTest;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.JSON;

public class AssetControllerTest extends BaseTest{

//	@Before
//	public void setUp() throws Exception {
//	}

//	@Test
//	public void testFixUpdateMethod() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testInsertAsset() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testUpdateAsset () throws Exception {
		String phonNumber ="13800138000";
		Asset asset = new Asset();
		asset.setPhoneNumber(phonNumber);
		BigDecimal balance = new BigDecimal("2000000000");
		asset.setBalance(balance);
		String jsonString=JSON.toJSONString(asset);
//		  mockMvc.perform((post("/asset/update")
//				 .param(jsonString)))
//				 .andExpect(status()
//				 .isOk())
//				 .andDo(print());  
		    super.mockMvc.perform(post("/asset/update")
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(jsonString))
				 .andExpect(status()
		  		 .isOk())
			     .andDo(print());  
	}

//	@Test
//	public void testGetAsset() {
//		fail("Not yet implemented");
//	}

}

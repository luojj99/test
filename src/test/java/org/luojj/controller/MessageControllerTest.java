package org.luojj.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.luojj.entity.MessageCenter;
import org.luojj.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import sun.util.logging.resources.logging;

public class MessageControllerTest extends BaseTest{
	
	 private static Logger logger = Logger.getLogger(MessageControllerTest.class);  
	
	@Autowired
	private MessageController messageController;

//	@Test
//	public void testFixUpdateMethod() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertMessage() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateMessage() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testGetMessageList() {
//		List<MessageCenter>list=messageController.getMsgList();
//		logger.info("messge列表："+list);
//	}

}

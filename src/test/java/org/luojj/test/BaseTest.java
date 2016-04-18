package org.luojj.test;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.junit.Assert.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
//表示继承了SpringJUnit4ClassRunner类 ,用于配置spring中测试的环境
@ContextConfiguration(locations = { "classpath*:srping-mvc.xml",
		"classpath*:spring-mybatis.xml" })
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
//记得要在XML文件中声明事务哦~~~我是采用注解的方式
@Transactional
public class BaseTest {
	@Autowired
	 public WebApplicationContext wac;
	 public MockMvc mockMvc;
	
	 @Before
		public void setup() {
			// webAppContextSetup 注意上面的static import
			// webAppContextSetup 构造的WEB容器可以添加fileter 但是不能添加listenCLASS
			// WebApplicationContext context =
			// ContextLoader.getCurrentWebApplicationContext();
			// 如果控制器包含如上方法 则会报空指针
			this.mockMvc = webAppContextSetup(this.wac).build();
		}
	 
	 @Test
	 public  void test(){
		 
	 }

}

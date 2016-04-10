package org.luojj.test;




import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.luojj.controller.HelloWorldController;
import org.luojj.model.Student;
import org.luojj.model.User;
import org.luojj.service.IStudentService;
import org.luojj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类 ,用于配置spring中测试的环境 
@ContextConfiguration(locations = {"classpath*:srping-mvc.xml","classpath*:spring-mybatis.xml"})  //用于指定配置文件所在的位置 

public class TestMybatis {  
    private static Logger logger = Logger.getLogger(TestMybatis.class);  
//  private ApplicationContext ac = null;  
    
    
    @Autowired
    private HelloWorldController helloWorldController;
    
	@Autowired
	@Qualifier("studentService")
    private IStudentService studentService;
	
	@Autowired
	private IUserService userService;
  
//  @Test 
//  public void test2() {  
//      ac = new ClassPathXmlApplicationContext("classpath*:spring-mybatis.xml");  
//      IStudentService studentService =  (IStudentService) ac.getBean("studentService");  
//      Student student =studentService.getStudentById(1);
//      System.out.println(student);
//  }  
  
    @Test  
    public void test1() {  
        Student student = studentService.getStudentById(1);  
        logger.info(JSON.toJSONString(student));  
    	  helloWorldController.test();
//        Assert.assertEquals("男", student.getGender());
    }  
    
    
    @Test
    public void testUserlogin(){
//    	User user = userService.getUserById(1L);
    	User user=userService.checkLogin("13800138000", "123");
    	logger.info(JSON.toJSONString(user));  
    	System.out.println(1111111111);
    }
    
    
    
    
    
    
   
}  

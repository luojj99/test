package org.luojj.controller;

import java.util.concurrent.CountDownLatch;

import javax.servlet.http.HttpServletRequest;

import org.luojj.model.Student;
import org.luojj.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {
	@Autowired
	@Qualifier("studentService")
    private IStudentService studentService;
	
	
	@RequestMapping(value="/student/id/{id}/password/{password}",method=RequestMethod.GET)
	public @ResponseBody Student toIndex(@PathVariable String id,
			@PathVariable String password){
		int userId = Integer.parseInt(id);
		Student student = this.studentService.getStudentById(userId);
		if (student.getId()==userId&&student.getName().equals(password)) {
			System.out.println("login success");
			return student;
		}else{
			System.out.println("fail");
			
			return null;
		}
			
		
	}

    @RequestMapping("/indexx")
    public void test(){
    	System.out.println("test");
    }
   
//    +----+-------------+--------+
//    | id | name        | gender |
//    +----+-------------+--------+
//    |  1 | 18000000000 | 男     |
//    |  2 | 123         | 女     |
//    +----+-------------+--------+

    
    
    
    
    
    
    

//@Override
//protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
//		HttpServletResponse arg1) throws Exception {
//	// TODO Auto-generated method stub
//	System.out.println("hello springmvc");  
//    return new ModelAndView("homepage/index");  
//}
    
}

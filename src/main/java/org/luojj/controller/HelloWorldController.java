package org.luojj.controller;

import java.util.concurrent.CountDownLatch;

import javax.servlet.http.HttpServletRequest;

import org.luojj.model.Student;
import org.luojj.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {
	static int count =0;
	@Autowired
	@Qualifier("studentService")
    private IStudentService studentService;

    @RequestMapping("/index")
    public void test(){
    	System.out.println("test"+(count++));
    }
    
    @RequestMapping("/showUser")
	public void toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		String password= request.getParameter("pas3sword");
		Student student = this.studentService.getStudentById(userId);
		if (student.getId()==userId&&student.getName().equals(password)) {
			System.out.println("login success"+(count++));
		}
		
		
	}
    
    
    
//	@RequestMapping(value = "{name}", method = RequestMethod.GET)
//	public @ResponseBody
//	Student getShopInJSON(@PathVariable String name) {
//
//		Student student = new Student();
//		shop.setName(name);
//		shop.setStaffName(new String[] { "mkyong1", "mkyong2" });
//		System.out.println("test");
//		return shop;
//
//	}

//@Override
//protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
//		HttpServletResponse arg1) throws Exception {
//	// TODO Auto-generated method stub
//	System.out.println("hello springmvc");  
//    return new ModelAndView("homepage/index");  
//}
    
}

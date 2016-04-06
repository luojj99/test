package org.luojj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {

    @RequestMapping("/index")
    public void test(){
    	System.out.println("test");
    }

//@Override
//protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
//		HttpServletResponse arg1) throws Exception {
//	// TODO Auto-generated method stub
//	System.out.println("hello springmvc");  
//    return new ModelAndView("homepage/index");  
//}
    
}

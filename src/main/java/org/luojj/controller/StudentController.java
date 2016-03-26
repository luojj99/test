package org.luojj.controller;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;

import org.luojj.model.Student;
import org.luojj.service.IStudentService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private IStudentService studentService;
	
	@RequestMapping("/showStudent")
	public String toIndex(HttpServletRequest request,Model model){
		int studentId =Integer.parseInt(request.getParameter("id"));
		Student student=this.studentService.getStudentById(studentId);
		
		return "showStudent";
	}

}

package org.luojj.service.impl;









import org.luojj.dao.StudentDao;



import org.luojj.model.Student;
import org.luojj.service.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements IStudentService{
	
	//因为MapperScannerConfigurer会把接口实例化为bean并自动注入到spring容器中，所以可以直接使用注解来注入到属性中
	//bean的默认id为该类类名，只是改为小写字母开头。这里会根据类型自动装配
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return this.studentDao.selectByPrimaryKey(id);
	}

}

package org.luojj.service.impl;




import javax.annotation.Resource;

import org.luojj.dao.IStudentDao;
import org.luojj.model.Student;
import org.luojj.service.IStudentService;
import org.springframework.stereotype.Service;

@Service("StudentService")
public class StudentServiceImpl implements IStudentService{
	@Resource
	private IStudentDao studentDao;

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return this.studentDao.selectByPrimaryKey(id);
	}

}

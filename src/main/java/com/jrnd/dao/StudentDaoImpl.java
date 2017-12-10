package com.jrnd.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jrnd.model.Student;

@Repository("studentDAO")
@Transactional
public class StudentDaoImpl implements StudentDao {
	@Autowired
	HibernateTemplate hibtemplate;

	public void setHibtemplate(HibernateTemplate hibtemplate) {
		this.hibtemplate = hibtemplate;
	}

	@Override
	@Transactional
	public Student addStudent(Student student) {
     System.out.println("Student Service create invoked:"+student.getStudentName());
	 hibtemplate.persist(student);
	 return student;	
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteStudent(String studentId) {
		Student id=new Student();
		id.setStudentId(studentId);
		hibtemplate.delete(studentId);
		
	}

	@Override
	@Transactional(readOnly=false)
	public Student updateStudent(Student student) {
		hibtemplate.update(student);
		return student;
		
	}

	@Override
	@Transactional(readOnly=true)
	public Student getStudentById(String studentId) {
		return hibtemplate.get(Student.class, studentId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Student> getAllStudent() {
		return hibtemplate.loadAll(Student.class);
	}

}

package com.jrnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrnd.dao.StudentDao;
import com.jrnd.model.Student;
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired(required=true)
    @Qualifier("studentDAO")
	 private StudentDao studentdao;

	@Override
	public Student addStudent(Student student) {
	System.out.println("Student Service create invoked:"+student.getStudentName());
       student=studentdao.addStudent(student);
		return student;
	}

	@Override
	public Student update(Student student) {
		System.out.println("Cusomer Service create invoked:"+student.getStudentName());
		student=studentdao.updateStudent(student);
		return student;
	}

	@Override
	public void deleteStudent(String studentId) {
		studentdao.deleteStudent(studentId);
		
	}

	@Override
	public Student getStudentById(String studentId) {
		return studentdao.getStudentById(studentId);
		
	}

	@Override
	public List<Student> getAllStudents() {
		 return studentdao.getAllStudent();
		
	}
	}

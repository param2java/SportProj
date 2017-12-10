package com.jrnd.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jrnd.model.Student;
import com.jrnd.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
Logger logger=Logger.getLogger(StudentController.class);

@Autowired(required=true)
@Qualifier("studentService")
private StudentService studentservice;

@GetMapping("/{studentId}")
public Student getCustomers(@PathVariable("studentId") String studentId){
	
	return studentservice.getStudentById(studentId);
}

@RequestMapping(value="/all",method=RequestMethod.GET)
public List<Student> allStudents(){
	List<Student> list = studentservice.getAllStudents();
	return list;
}


@RequestMapping(value="/update",method=RequestMethod.POST)
public Student editCustomer(@RequestBody Student student){
	 student = studentservice.update(student);
	return student;
	
}
@RequestMapping(value="/add",method=RequestMethod.POST)
public Student addStudent(@RequestBody Student student){
	System.out.println("Student controller create invoked:"+student.getStudentName());
   student=studentservice.addStudent(student);
	return student;
}

@RequestMapping(value="/delete/{studentId}",method=RequestMethod.GET)
public void delete(@PathVariable("studentId") String studentId){
   
	//customerService.deleteCustomer(customerId);
	//StatusDTO status = new StatusDTO();
	studentservice.deleteStudent(studentId);
	
	
}

}

package com.jrnd.service;

import java.util.List;

import com.jrnd.model.Student;

public interface StudentService {
 Student addStudent(Student student);
 Student update(Student student);
 void deleteStudent(String studentId);
 Student getStudentById(String studentId);
 List<Student> getAllStudents();
 
}

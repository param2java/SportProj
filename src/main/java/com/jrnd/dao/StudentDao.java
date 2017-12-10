package com.jrnd.dao;

import java.util.List;

import com.jrnd.model.Student;

public interface StudentDao {
 Student addStudent(Student student);
 void deleteStudent(String studentId);
 Student updateStudent(Student student);
 Student getStudentById(String studentId);
 List<Student> getAllStudent();
}

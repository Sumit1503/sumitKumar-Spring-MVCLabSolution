package com.iitr.fest.service;

import java.util.List;

import com.iitr.fest.entity.Student;

public interface StudentService {

	public List<Student> viewAll();

	public void registerStudent(Student student);

	public void deleteById(Integer studentId);

	public Student findStudent(Integer studentId);

}

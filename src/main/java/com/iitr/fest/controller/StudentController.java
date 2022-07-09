package com.iitr.fest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iitr.fest.entity.Student;
import com.iitr.fest.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/view")
	public String viewStudents(Model model)
	{
		List<Student> studentList = studentService.viewAll();
		
		model.addAttribute("studentList",studentList);
		return "Student";
	}
	
	@RequestMapping("/register")
	public String registerStudent(@RequestParam("id") Integer studentId,
			@RequestParam("studentName") String name,
			@RequestParam("department") String department,
			@RequestParam("country") String country)
	{
		Student student;
		System.out.println(studentId+"$$$$$$$$$$$$$$$$$$");
		if(studentId==null)
		{
			student = new Student();
			student.setStudentName(name);
			student.setDepartment(department);
			student.setCountry(country);		
		}
		else
		{
			student = studentService.findStudent(studentId);
			student.setStudentName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}

		
		studentService.registerStudent(student);
		return "redirect:view";
	}
	
	@RequestMapping("/new_registration")
	public String newRegistration()
	{
		return "StudentForm";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") Integer studentId) 
	{
		studentService.deleteById(studentId);
		return "redirect:view";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("studentId")Integer studentId, Model model)
	{
		Student student= studentService.findStudent(studentId);
		model.addAttribute("student", student);
		
		return "StudentForm";
	}
	
	

}

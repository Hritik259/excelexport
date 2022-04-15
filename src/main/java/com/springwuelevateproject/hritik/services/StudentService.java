package com.springwuelevateproject.hritik.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;


import com.springwuelevateproject.hritik.model.Student;

public interface StudentService {
	public List<Student>getstudents();

	public Student getstudentsById(int studentid);

	public void saveOrUpdate(Student student);

	public List<Student> getAllStudents();
	

}

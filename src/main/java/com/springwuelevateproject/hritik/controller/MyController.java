package com.springwuelevateproject.hritik.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springwuelevateproject.hritik.excel.UserExcelExporter;
import com.springwuelevateproject.hritik.model.Student;
import com.springwuelevateproject.hritik.repository.StudentRepository;
import com.springwuelevateproject.hritik.services.StudentService;

@RestController
public class MyController {

	@Autowired
	private StudentService studentservice;

	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}

	// get the students
	@GetMapping("/students")
	public List<Student> getstudents() {

		return this.studentservice.getstudents();

	}

	// creating a get mapping that retrieves the detail of a specific student
	// this is an API
	@GetMapping("/students/{studentid}")
	public Student getstudents(@PathVariable("studentid") int studentid) {
		return studentservice.getstudentsById(studentid);
	}

	@PostMapping("/students")
	public Student saveBook(@RequestBody Student student) {
		studentservice.saveOrUpdate(student);
		return student;
	}
	@Autowired
	private StudentRepository studentRepo;

	@GetMapping("/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=Student_info.xlsx";

		response.setHeader(headerKey, headervalue);
		List<Student> listStudent = studentRepo.findAll();
		UserExcelExporter exp = new UserExcelExporter(listStudent);
		exp.export(response);

	}


}

package com.jsp.college.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.college.recruitment.dto.StudentDto;
import com.jsp.college.recruitment.helper.ResponseStructure;
import com.jsp.college.recruitment.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public ResponseStructure<StudentDto> saveStudent(@RequestBody StudentDto dto)
	{
		ResponseStructure<StudentDto> rs=service.saveStudent(dto);
		return rs;
	}
	
	@DeleteMapping("/delete/{email}")
	public void deleteStudent(@PathVariable String email)
	{
		service.deleteById(email);
	
	}
	
	@DeleteMapping("/deleteall")
	public void deleteAllStudent() {
		service.deleteall();
	}
	
	@PutMapping("/update")
	public void updateStudent()
	{
//		service.update();
	}
//	
	@GetMapping("/fetch/{email}")
	public Object fetchStudent(@PathVariable String email)
	{
		Object o1=service.fetchById(email);
		return o1;
	}
	
	@GetMapping("/fetchall")
	public Object fetchALL() {
		return service.fetchAll();
		
	}
	
}

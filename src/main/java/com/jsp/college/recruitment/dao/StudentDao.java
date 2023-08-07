package com.jsp.college.recruitment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.college.recruitment.dto.StudentDto;
import com.jsp.college.recruitment.repository.StudentRepository;

@Component
public class StudentDao {

	@Autowired
	StudentRepository repository;

	public void saveStudent(StudentDto dto) {
		repository.save(dto);
	}

	public Optional<StudentDto> fetchById(String email) {
		Optional<StudentDto> d1 = repository.findById(email);
//		if(d1.isPresent()) {
			return d1;
//		}
//		return null;
	}

	public List<StudentDto> fetchAll() {
	    return repository.findAll();
	}

	public void deleteById(String email) {
		 repository.deleteById(email);	 
	}
	
	public void deleteAll() {
		repository.deleteAll();
		
	}

	public void update() {
//		repository.flush();
	}
	
}

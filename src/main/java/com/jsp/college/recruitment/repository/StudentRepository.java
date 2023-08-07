package com.jsp.college.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jsp.college.recruitment.dto.StudentDto;

@Component
public interface StudentRepository extends JpaRepository<StudentDto, String>{

}

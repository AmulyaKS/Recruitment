package com.jsp.college.recruitment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.college.recruitment.dao.StudentDao;
import com.jsp.college.recruitment.dto.StudentDto;
import com.jsp.college.recruitment.exceptionHandling.UserDefinedException;
import com.jsp.college.recruitment.helper.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public ResponseStructure<StudentDto> saveStudent(StudentDto dto) {
		dao.saveStudent(dto);
		ResponseStructure<StudentDto> responseStructure = new ResponseStructure<StudentDto>();
		responseStructure.setMessage("SAVED SUCCESSFULLY");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dto);
		return responseStructure;
	}

	public ResponseStructure<StudentDto> fetchById(String email) {
		Optional<StudentDto> d1 = dao.fetchById(email);
		if(d1.isPresent())
		{
			ResponseStructure<StudentDto> responseStructure=new ResponseStructure<StudentDto>();
			responseStructure.setMessage("fetched");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(d1.get());
			return responseStructure;
		}
		throw new UserDefinedException("No such Element Found");
		
		
		
//		if (d1 != null) {
//			ResponseStructure<StudentDto> responseStructure = new ResponseStructure<StudentDto>();
//			responseStructure.setMessage("FETCHED SUCCESSFULLY");
//			responseStructure.setStatus(HttpStatus.FOUND.value());
//			responseStructure.setData(d1);
//			return responseStructure;
//		} else {
//			ResponseStructure<StudentDto> responseStructure = new ResponseStructure<StudentDto>();
//			responseStructure.setMessage("NOT FOUND");
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(null);
//			return responseStructure;
//		}

	}

	public ResponseStructure<List<StudentDto>> fetchAll() {
		ResponseStructure<List<StudentDto>> list=new ResponseStructure<>();
		
		list.setMessage("All Data Fetched");
		list.setStatus(HttpStatus.FOUND.value());
		list.setData(dao.fetchAll());
		
		return list;
	}

	public void deleteById(String email) {
		 dao.deleteById(email);
//		 if(d1.isPresent())
//			{
//				ResponseStructure<StudentDto> responseStructure=new ResponseStructure<StudentDto>();
//				responseStructure.setMessage("Data Deleted Successfully");
//				responseStructure.setStatus(HttpStatus.FOUND.value());
//				responseStructure.setData(null);
//				return responseStructure;
//			}
//			throw new UserDefinedException("No such Element Found");
			
	}
	
	public void deleteall() {
		dao.deleteAll();
	}

	public void update() {
//		dao.update();
	}
}


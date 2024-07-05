package com.sms.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.apis.model.Student;
import com.sms.apis.services.StudentService;

@RestController
@RequestMapping("/apis")
@CrossOrigin
public class StudentController {

	@Autowired
	StudentService service;

	// add student
	@PostMapping(value = "/add")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {

		String str = service.addStudent(student);

		if (str == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(str);
		}
		return ResponseEntity.ok(str);

	}

	// get student by id
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<?> getStudent(@PathVariable int id) {

		Student student = service.getStudent(id);

		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(student);
		}
		return ResponseEntity.ok(student);

	}

	// get all student
	@GetMapping(value = "/get-all")
	public ResponseEntity<List<Student>> getAllStudents() {

		List<Student> list= service.getAllStudents();
		if (list.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(list);
		}
		return ResponseEntity.ok(list);


	}

	//delete student by id
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		
		String str=service.deleteStudent(id);
		if (str==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(str);
		}
		return ResponseEntity.ok(str);
		
	}
	
	//update student 
	@PutMapping(value = "/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		
		Student stu=service.updateStudent(student);
		if (stu==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stu);
		}
		return ResponseEntity.ok(stu);
	}
	
	//add student relatives
	
//	@PostMapping(value = "/add-relative/{id}")
//	public ResponseEntity<?> addStudentRelatives(@PathVariable int id) {
//		
//		Student stu=service.addStudentRelatives(id);
//		
//	}
}

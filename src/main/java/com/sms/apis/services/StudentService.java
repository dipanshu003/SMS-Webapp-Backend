package com.sms.apis.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sms.apis.model.Student;
import com.sms.apis.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository stuRepo;

	public String addStudent(Student student) {

		if(!stuRepo.existsByEmail(student.getEmail())){
			stuRepo.save(student);
			return "Student saved successfully.";
		}
		return null;
	}

	public Student getStudent(int id) {
		return stuRepo.findById(id).orElse(null);
	}

	public List<Student> getAllStudents() {
		return stuRepo.findAll();
	}

	public String deleteStudent(int id) {
		if (stuRepo.existsById(id)) {
			Student stu = stuRepo.findById(id).orElse(null);
			if (stu != null) {
				stuRepo.delete(stu);
				return stu.getFirstName() + " is deleted successfully.";
			}
		}
		return null;
	}

	public Student updateStudent(Student student) {
		Student dbStudent = stuRepo.findById(student.getId()).orElse(null);
		if (dbStudent != null) {
			dbStudent.setAge(student.getAge());
			dbStudent.setEmail(student.getEmail());
			dbStudent.setFirstName(student.getFirstName());
			dbStudent.setLastName(student.getLastName());
			dbStudent.setPhoneNumber(student.getPhoneNumber());
			dbStudent.setRelatives(student.getRelatives());
			return stuRepo.save(dbStudent);
		}
		return null;
	}

//	public Student addStudentRelatives(int id) {
//		
//		Student stu=stuRepo.findById(id).orElse(null);	
//		
//		if (stu!=null) {
//			
//			
//			
//		}
//		
//	}
}

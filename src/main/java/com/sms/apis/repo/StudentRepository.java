package com.sms.apis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.apis.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	boolean existsByEmail(String email);


}

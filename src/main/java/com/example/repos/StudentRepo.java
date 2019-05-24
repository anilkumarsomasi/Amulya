package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.beans.Student;

public interface StudentRepo  extends JpaRepository<Student, Long>{

	
	@Query(value = "SELECT * FROM student u WHERE u.age = :age", nativeQuery=true)
	public List<Student> getStudentsByAge(@Param("age") int age);
	

	
}

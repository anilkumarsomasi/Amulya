package com.example.serviceimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Student;
import com.example.repos.StudentRepo;
import com.example.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo studentRepo;
	
	
	@Override
	public Student saveStudent(Student student) {
		System.out.println(student.getName());
		student.setName("JNTUH_" + student.getName());
		System.out.println(student.getName());
		return studentRepo.save(student);
	}


	@Override
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}


	@Override
	public List<Student> getStudentsbyAge(int age) {
	
		return studentRepo.getStudentsByAge(age);
	}

}

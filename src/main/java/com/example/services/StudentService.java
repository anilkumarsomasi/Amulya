package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.beans.Student;

@Service
public interface StudentService {

	public Student saveStudent(Student student);

	public List<Student> getStudents();

	public List<Student> getStudentsbyAge(int age);


}

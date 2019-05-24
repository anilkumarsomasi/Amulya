package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Student;
import com.example.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	
	@GetMapping("/getStudentsbyAge")
	public List<Student> getStudentsbyAge(@RequestParam("age") int age){
		return studentService.getStudentsbyAge(age);
	}
	
	
	@GetMapping("/getStudents")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	
	@RequestMapping(value = "/saveStudentsInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> saveStudentsInfo(@RequestBody Student student) {
		try {
			return  new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.BAD_REQUEST);
			
		}catch (Exception e) {
			return  new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.BAD_REQUEST);

		}
		
	}
	
	
	@RequestMapping(value = "/saveStudentsResp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student saveStudentsResp(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	
	/*public ResponseEntity<String> voteForMotion(@RequestBody VoteDetialsBO votedetails) {
		try {
			return new ResponseEntity<String>(motionVotingSystem.voteforMotion(votedetails), HttpStatus.OK);

		} catch (MotionSystemVotingException exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}*/
	
	

}

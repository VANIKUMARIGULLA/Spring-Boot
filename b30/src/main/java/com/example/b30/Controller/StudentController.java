package com.example.b30.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.b30.Exception.ResourceNotFoundException;
import com.example.b30.Model.Student;
import com.example.b30.Service.StudentServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentService;

	@PostMapping("/students")
	private Student createStudent(@RequestBody Student student) {
		System.out.println(student);
		
		return studentService.createStudent(student);
	}
	
	@GetMapping("/students")
	private List getAllStudents() {
		return studentService.getAll();
	}
	
	@GetMapping("/students/{id}")

	public ResponseEntity getStudentById(@PathVariable(value = "id") Long studentId)

	throws ResourceNotFoundException {

	Student student = studentService.findByStudentId(studentId)

	.orElseThrow(() -> new ResourceNotFoundException("student not found for this id :: " + studentId));

	return ResponseEntity.ok().body(student);

	}
	
	@PutMapping("/students/{id}")

	public ResponseEntity updateStudent(@PathVariable(value = "id") Long studentId,

	@RequestBody Student studentDetails) throws ResourceNotFoundException {

	Student student = studentService.findByStudentId(studentId)

	.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

	student.setFirstName(studentDetails.getFirstName());

	final Student updatedStudent = studentService.save(student);

	return ResponseEntity.ok(updatedStudent);

	}
	
	@DeleteMapping("/students/{id}")

	public Map deleteStudent(@PathVariable(value = "id") Long studentId)

	throws ResourceNotFoundException {

	Student student = studentService.findByStudentId(studentId)

	.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

	studentService.delete(student);

	Map response = new HashMap<>();

	response.put("deleted", Boolean.TRUE);

	return response;

	}
	
	
	
}

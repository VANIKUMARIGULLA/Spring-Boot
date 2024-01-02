package com.example.b30.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.b30.Model.Student;
import com.example.b30.Repository.StudentRepository;

@Service
public class StudentServiceImpl{
	

	@Autowired
	
	private StudentRepository studentRepository;
	
	
	
	public Student createStudent(Student student) {
	
	return studentRepository.save(student);
	}
	
	public List getAll() {
		return studentRepository.findAll();
	}

	
	public Optional<Student> findByStudentId(long studentId){

		return studentRepository.findById(studentId);

		}
	
	public Student save(Student student) {

		return studentRepository.save(student);

	}
	
	public void delete(Student student){

		studentRepository.delete(student);

	}
	
	
}

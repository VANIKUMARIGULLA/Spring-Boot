package com.example.b30.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.b30.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


}

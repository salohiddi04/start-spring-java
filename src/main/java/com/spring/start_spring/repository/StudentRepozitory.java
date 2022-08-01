package com.spring.start_spring.repository;

import com.spring.start_spring.dto.Studentdto;
import com.spring.start_spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepozitory extends JpaRepository<Student, Integer> {
    List<Student> findAllByAge (Integer age);
    List<Student> findAll();
}

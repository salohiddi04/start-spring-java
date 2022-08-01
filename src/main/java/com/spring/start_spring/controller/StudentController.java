package com.spring.start_spring.controller;

import com.spring.start_spring.dto.ResponsDto;
import com.spring.start_spring.dto.Studentdto;
import com.spring.start_spring.entity.Student;
import com.spring.start_spring.servis.impl.StudentServisImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController{
    private final StudentServisImpl studentServis;

    public StudentController(StudentServisImpl studentServis1) {
        this.studentServis = studentServis1;
    }

    @PostMapping
    public ResponsDto addStudent(@RequestBody Studentdto studentdto){
        return studentServis.addstudent(studentdto);
    }

    @PutMapping
    public ResponsDto updateStudent(@RequestBody Student studentdto){
        return studentServis.setupdatestudent(studentdto);
    }

    @DeleteMapping("{id}")
    public ResponsDto deletStudent(@PathVariable Integer id){
        return studentServis.deletestudent(id);
    }

    @GetMapping
    public List<Student> select(){
        return studentServis.getStudent();
    }

}

package com.spring.start_spring.servis.impl;

import com.spring.start_spring.dto.ResponsDto;
import com.spring.start_spring.dto.Studentdto;
import com.spring.start_spring.entity.Student;
import com.spring.start_spring.repository.StudentRepozitory;
import com.spring.start_spring.servis.StudentServis;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class StudentServisImpl implements StudentServis {
    public static List<Studentdto> studentdtos = new ArrayList<>();
    private final StudentRepozitory studentRepozitory;

    public StudentServisImpl(StudentRepozitory studentRepozitory) {
        this.studentRepozitory = studentRepozitory;
    }

    @Override
    public ResponsDto addstudent(@RequestBody Studentdto studentdto){
        Student student = Student.builder()
                .age(studentdto.getAge())
                .course(studentdto.getCourse())
                .name(studentdto.getName())
                .brithdate(studentdto.getBrithdate())
                .build();

        studentRepozitory.save(student);

        return ResponsDto.builder()
                .code(0)
                .succes(true)
                .message("sucess true")
                .build();
    }

    @Override
    public ResponsDto setupdatestudent(@RequestBody Student studentd){
        Student student1 = studentRepozitory.save(studentd);

        return  ResponsDto.builder()
                .code(0)
                .succes(true)
                .message("update")
                .build();
    }

    @Override
    public ResponsDto deletestudent( Integer id) {
        Student student = studentRepozitory.getOne(id);
       studentRepozitory.delete(student);

       return ResponsDto.builder()
                .code(0)
                .succes(true)
                .message("on delete")
                .build();
    }

    @Override
    public List<Student> getStudent() {
        return studentRepozitory.findAll();

    }

}

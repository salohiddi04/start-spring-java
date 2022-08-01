package com.spring.start_spring.servis;

import com.spring.start_spring.dto.ResponsDto;
import com.spring.start_spring.dto.Studentdto;
import com.spring.start_spring.entity.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentServis {
    public ResponsDto addstudent(@RequestBody Studentdto studentdto);
    public ResponsDto setupdatestudent(@RequestBody Student studentdto);
    public ResponsDto deletestudent(@RequestParam Integer id);
    public List<Student> getStudent();
    }

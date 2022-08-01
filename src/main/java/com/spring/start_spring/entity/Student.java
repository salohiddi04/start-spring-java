package com.spring.start_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(generator = "Java_student_seq")
    @SequenceGenerator(name = "Java_student_seq", sequenceName = "student_id_seq",allocationSize = 1)

    @Column(name  = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "course")
    private String course;

    @Column(name = "birth_date")
    private Integer brithdate;

    public Student(String name, Integer age, String course, Integer brithdate) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.brithdate = brithdate;
    }
}

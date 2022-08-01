package com.spring.start_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studentdto {
    private Integer id;
    private String name;
    private Integer age;
    private String course;
    private Integer brithdate;
}

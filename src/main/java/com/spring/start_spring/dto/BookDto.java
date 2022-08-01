package com.spring.start_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {
    private  Integer id;
    private String name;
    private Integer price;
    private String avtorname;


}


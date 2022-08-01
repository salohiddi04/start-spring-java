package com.spring.start_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Book{
        private Integer id;
        private  String name;
        private  Integer price;
        private  Integer avterid;
    }


package com.spring.start_spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avtor {
    private  String name;
    private String lastname;
    private int year;
    private int id;


}

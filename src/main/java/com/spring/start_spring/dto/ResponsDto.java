package com.spring.start_spring.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsDto {
    private int code;
    private boolean succes;
    private String message;
}

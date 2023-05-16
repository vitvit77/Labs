package com.example.labsnewcourse.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRedisDTO {
    private String id;
    private String name;
    private String department;
    private Integer age;
    private Float salary;
}

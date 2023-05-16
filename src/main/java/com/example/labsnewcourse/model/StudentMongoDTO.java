package com.example.labsnewcourse.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentMongoDTO {
    private String name;
    private String group;
    private Integer age;
    private String course;
}

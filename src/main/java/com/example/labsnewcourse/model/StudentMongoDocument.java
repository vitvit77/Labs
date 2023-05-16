package com.example.labsnewcourse.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("StudentsDocument")
public class StudentMongoDocument {
    @Id
    private String id;
    private String name;
    private String group;
    private Integer age;
    private String course;
}

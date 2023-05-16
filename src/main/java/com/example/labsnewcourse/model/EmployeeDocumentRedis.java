package com.example.labsnewcourse.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Setter
@Getter
@RedisHash("project")
public class EmployeeDocumentRedis {
    private String id;
    private String name;
    private String department;
    private Integer age;
    private Float salary;
}

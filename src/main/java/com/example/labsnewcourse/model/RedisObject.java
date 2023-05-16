package com.example.labsnewcourse.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@RedisHash("project")
public class RedisObject {
    private String id;
    private String name;
    private String number;
}

package com.example.labsnewcourse.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfiguration {
    @Autowired
    private MongoDatabaseFactory mongoDatabaseFactory;

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDatabaseFactory);
        return mongoTemplate;
    }
}

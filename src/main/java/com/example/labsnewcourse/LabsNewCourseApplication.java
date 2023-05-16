package com.example.labsnewcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.*")
@EnableMongoRepositories("com.*")
public class LabsNewCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabsNewCourseApplication.class, args);
	}

}

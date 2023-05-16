package com.example.labsnewcourse.repository;

import com.example.labsnewcourse.model.StudentMongoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDocumentRepository extends MongoRepository<StudentMongoDocument, String> {
}

package com.example.labsnewcourse.service;

import com.example.labsnewcourse.model.StudentMongoDTO;
import com.example.labsnewcourse.model.StudentMongoDocument;
import com.example.labsnewcourse.repository.MongoDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class MongoDBService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoDocumentRepository mongoDocumentRepository;

    public StudentMongoDocument create(StudentMongoDTO studentMongoDTO) {
        StudentMongoDocument studentMongoDocument = new StudentMongoDocument();
        studentMongoDocument.setName(studentMongoDTO.getName());
        studentMongoDocument.setGroup(studentMongoDTO.getGroup());
        studentMongoDocument.setCourse(studentMongoDTO.getCourse());
        studentMongoDocument.setAge(studentMongoDTO.getAge());
        mongoDocumentRepository.save(studentMongoDocument);
        return studentMongoDocument;
    }

    public StudentMongoDocument update(String documentId, StudentMongoDTO studentMongoDTO) {
        Optional<StudentMongoDocument> optionalStudentMongoDocument = Optional.ofNullable(this.find(documentId));
        if (optionalStudentMongoDocument.isPresent()) {
            StudentMongoDocument studentMongoDocument = optionalStudentMongoDocument.get();
            studentMongoDocument.setName(studentMongoDTO.getName());
            studentMongoDocument.setGroup(studentMongoDTO.getGroup());
            studentMongoDocument.setCourse(studentMongoDTO.getCourse());
            studentMongoDocument.setAge(studentMongoDTO.getAge());
            return mongoTemplate.save(studentMongoDocument);
        }
        return null;
    }

    public StudentMongoDocument find(String documentId) {
        Optional<StudentMongoDocument> optionalStudentMongoDocument =  mongoDocumentRepository.findById(documentId);
        if (optionalStudentMongoDocument.isPresent()) {
            StudentMongoDocument studentMongoDocument = optionalStudentMongoDocument.get();
            return studentMongoDocument;
        }
        return null;
    }

    public void delete(String documentId) {
        mongoDocumentRepository.deleteById(documentId);
    }
}

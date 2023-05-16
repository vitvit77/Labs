package com.example.labsnewcourse.controller;

import com.example.labsnewcourse.model.PGDocumentsEntity;
import com.example.labsnewcourse.model.StudentMongoDTO;
import com.example.labsnewcourse.model.StudentMongoDocument;
import com.example.labsnewcourse.model.SuccessDTOResponse;
import com.example.labsnewcourse.service.MongoDBService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Work with students"})
@SwaggerDefinition(tags = {@Tag(name = "Work with students", description = "Work with students REST API")})
@RestController
@RequestMapping("/api/mongo")

public class MongoDBController {
    @Autowired
    private MongoDBService mongoDBService;

    @Operation(summary = "Create student")
    @ApiResponse(code = 200, message = "Student created", response = StudentMongoDocument.class)
    @PostMapping("/student")
    public StudentMongoDocument createDocument(@RequestBody StudentMongoDTO studentMongoDTO) {
        return mongoDBService.create(studentMongoDTO);
    }

    @Operation(summary = "Update student")
    @ApiResponse(code = 200, message = "Student update", response = StudentMongoDocument.class)
    @PutMapping("/student")
    public StudentMongoDocument updateDocument(@RequestBody StudentMongoDTO studentMongoDTO, @RequestParam String documentId) {
        return mongoDBService.update(documentId, studentMongoDTO);
    }
    @Operation(summary = "Getting student")
    @ApiResponse(code = 200, message = "Student getting", response = StudentMongoDocument.class)
    @GetMapping("/student")
    public StudentMongoDocument findDocument(@RequestParam String documentId) {
        return mongoDBService.find(documentId);
    }

    @Operation(summary = "Delete student")
    @ApiResponse(code = 200, message = "Student deleted", response = SuccessDTOResponse.class)
    @DeleteMapping("/student")
    public SuccessDTOResponse deleteDocument(@RequestParam String documentId) {
        mongoDBService.delete(documentId);
        SuccessDTOResponse successDTOResponse = new SuccessDTOResponse();
        successDTOResponse.setResult(true);
        return successDTOResponse;
    }
}

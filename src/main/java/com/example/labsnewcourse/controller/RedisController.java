package com.example.labsnewcourse.controller;

import com.example.labsnewcourse.model.*;
import com.example.labsnewcourse.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Work with employee"})
@SwaggerDefinition(tags = {@Tag(name = "Work with employee", description = "Work with employee REST API")})
@RestController
@RequestMapping("/api/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @Operation(summary = "Create employee")
    @ApiResponse(code = 200, message = "Employee create", response = EmployeeDocumentRedis.class)
    @PostMapping("/employee")
    public EmployeeDocumentRedis createDocument(@RequestBody EmployeeRedisDTO employeeRedisDTO) {
        return redisService.createDocument(employeeRedisDTO);
    }

    @Operation(summary = "Updating employee")
    @ApiResponse(code = 200, message = "Employee updating", response = EmployeeDocumentRedis.class)
    @PutMapping("/employee")
    public EmployeeDocumentRedis updateDocument(@RequestBody EmployeeRedisDTO employeeRedisDTO, @RequestParam String id) {
        return redisService.updateDocument(id, employeeRedisDTO);
    }

    @Operation(summary = "Getting employee")
    @ApiResponse(code = 200, message = "Employee getting", response = EmployeeDocumentRedis.class)
    @GetMapping("/employee")
    public EmployeeDocumentRedis view(@RequestParam String id) {
        return redisService.find(id);
    }

    @Operation(summary = "Delete employee")
    @ApiResponse(code = 200, message = "Employee deleted", response = SuccessDTOResponse.class)
    @DeleteMapping("/employee")
    public SuccessDTOResponse deleteDocument(@RequestParam String id) {
        redisService.delete(id);
        SuccessDTOResponse successDTOResponse = new SuccessDTOResponse();
        successDTOResponse.setResult(true);
        return successDTOResponse;
    }
}


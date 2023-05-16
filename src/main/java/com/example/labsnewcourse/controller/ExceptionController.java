package com.example.labsnewcourse.controller;

import com.example.labsnewcourse.model.Response;
import com.example.labsnewcourse.model.ResponseMessage;
import com.example.labsnewcourse.model.Type;
import com.example.labsnewcourse.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/exception")
public class ExceptionController {

    @Autowired
    private ExceptionService exceptionService;
    @GetMapping("/execute")
    public @ResponseBody Response execute(@RequestParam Type type) throws SQLException {
        return exceptionService.execute(type);
    }
}

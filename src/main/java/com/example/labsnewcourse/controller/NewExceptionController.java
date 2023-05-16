package com.example.labsnewcourse.controller;


import com.example.labsnewcourse.exceptions.MyException;
import com.example.labsnewcourse.model.Response;
import com.example.labsnewcourse.model.ResponseMessage;
import com.example.labsnewcourse.model.Type;
import com.example.labsnewcourse.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/exception_new")
public class NewExceptionController {
    @Autowired
    private ExceptionService exceptionService;

    @GetMapping("/execute/string")
    public @ResponseBody ResponseMessage executeString(@RequestParam Type type) throws MyException {
        return exceptionService.executeString(type);
    }
}

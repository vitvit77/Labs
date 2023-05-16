package com.example.labsnewcourse.controller;

import com.example.labsnewcourse.exceptions.MyException;
import com.example.labsnewcourse.model.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public @ResponseBody Response unknownError() {
        Response response = new Response("Unknown Error");
        return response;
    }

    @ExceptionHandler({SQLException.class})
    public @ResponseBody Response sqlError() {
        Response response = new Response("SQL Exception");
        return response;
    }

    @ExceptionHandler({MyException.class})
    public @ResponseBody Response myError() {
        Response response = new Response("My Exception");
        return response;
    }

    @ExceptionHandler({Exception.class})
    public @ResponseBody Response exceptionError() {
        Response response = new Response("Exception");
        return response;
    }
}

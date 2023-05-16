package com.example.labsnewcourse.controller;

import com.example.labsnewcourse.model.CalculateRequestDTO;
import com.example.labsnewcourse.model.CalculateResponseDTO;
import com.example.labsnewcourse.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class CalculateController {
    @Autowired
    private CalculateService calculateService;

    @PostMapping("/sum")
    public @ResponseBody CalculateResponseDTO calculate(@RequestBody CalculateRequestDTO calculateRequestDTO) {
        return calculateService.calculate(calculateRequestDTO);
    }
}

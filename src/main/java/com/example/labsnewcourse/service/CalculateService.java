package com.example.labsnewcourse.service;

import com.example.labsnewcourse.model.CalculateRequestDTO;
import com.example.labsnewcourse.model.CalculateResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    public CalculateResponseDTO calculate(CalculateRequestDTO calculateRequestDTO) {
        int result = calculateRequestDTO.getFirstValue() + calculateRequestDTO.getSecondValue();
        CalculateResponseDTO calculateResponseDTO = new CalculateResponseDTO();
        calculateResponseDTO.setResult(result);
        return calculateResponseDTO;
    }
}

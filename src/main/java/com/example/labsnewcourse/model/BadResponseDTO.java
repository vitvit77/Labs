package com.example.labsnewcourse.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BadResponseDTO {
    private String textError;
    private Integer codeError;
}

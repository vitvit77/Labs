package com.example.labsnewcourse.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class PGDocumentsEntityDTO {
    private String id;
    private String name;
    private String body;
    private PGDocumentsTypeEnum type;
    private Timestamp create_date;
    private Timestamp sign_date;
    private String login;
}

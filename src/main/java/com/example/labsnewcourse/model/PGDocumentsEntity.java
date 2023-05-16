package com.example.labsnewcourse.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "documents")
@Getter
@Setter
public class PGDocumentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private long Id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="type")
    @Enumerated(EnumType.ORDINAL)
    private PGDocumentsTypeEnum type;

    @Column(name="body", nullable = false)
    private String body;

    @Column(name="create_date", columnDefinition = "timestamp with time zone")
    private Timestamp create_date;

    @Column(name="sign_date", columnDefinition = "timestamp with time zone")
    private Timestamp sign_date;

    @Column(name="login")
    private String login;
}

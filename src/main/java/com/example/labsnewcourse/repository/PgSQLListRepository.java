package com.example.labsnewcourse.repository;

import com.example.labsnewcourse.model.PGDocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PgSQLListRepository extends JpaRepository<PGDocumentsEntity, Long> {

}
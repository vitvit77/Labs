package com.example.labsnewcourse.service;

import com.example.labsnewcourse.model.*;
import com.example.labsnewcourse.repository.PgSQLListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class PgSQLService {
    @Autowired
    private PgSQLListRepository pgSQLListRepository;

    public PGDocumentsEntity createDocument(PGDocumentsEntityDTO pgDocumentsEntityDTO) {
        PGDocumentsEntity pgDocumentsEntity = new PGDocumentsEntity();
        pgDocumentsEntity.setName(pgDocumentsEntityDTO.getName());
        pgDocumentsEntity.setBody(pgDocumentsEntityDTO.getBody());
        pgDocumentsEntity.setType(pgDocumentsEntityDTO.getType());
        pgDocumentsEntity.setLogin(pgDocumentsEntityDTO.getLogin());
        pgDocumentsEntity.setCreate_date(new Timestamp(System.currentTimeMillis()));
        if (pgDocumentsEntityDTO.getSign_date() != null) {
            pgDocumentsEntity.setSign_date(pgDocumentsEntityDTO.getSign_date());
        }
        pgDocumentsEntity.setLogin(pgDocumentsEntityDTO.getLogin());
        return pgSQLListRepository.save(pgDocumentsEntity);
    }

    public PGDocumentsEntity update(Integer id, PGDocumentsEntityDTO pgDocumentsEntityDTO) {
        Optional<PGDocumentsEntity> optionalPGDocumentsEntity = Optional.ofNullable(this.find(id));
        if (optionalPGDocumentsEntity.isPresent()) {
            PGDocumentsEntity pgDocumentsEntity = optionalPGDocumentsEntity.get();
            pgDocumentsEntity.setName(pgDocumentsEntityDTO.getName());
            pgDocumentsEntity.setBody(pgDocumentsEntityDTO.getBody());
            pgDocumentsEntity.setType(pgDocumentsEntityDTO.getType());
            pgDocumentsEntity.setLogin(pgDocumentsEntityDTO.getLogin());
            pgDocumentsEntity.setCreate_date(new Timestamp(System.currentTimeMillis()));
            if (pgDocumentsEntityDTO.getSign_date() != null) {
                pgDocumentsEntity.setSign_date(pgDocumentsEntityDTO.getSign_date());
            }
            pgDocumentsEntity.setLogin(pgDocumentsEntityDTO.getLogin());
            return pgSQLListRepository.save(pgDocumentsEntity);
        }
        return null;
    }
    public PGDocumentsEntity find(Integer id) {
        Optional<PGDocumentsEntity> optionalPGDocumentsEntity =  pgSQLListRepository.findById(Long.valueOf(id));
        if (optionalPGDocumentsEntity.isPresent()) {
            PGDocumentsEntity pgDocumentsEntity = optionalPGDocumentsEntity.get();
            return pgDocumentsEntity;
        }
        return null;
    }

    public void delete(Integer id) {
        pgSQLListRepository.deleteById(Long.valueOf(id));
    }
}

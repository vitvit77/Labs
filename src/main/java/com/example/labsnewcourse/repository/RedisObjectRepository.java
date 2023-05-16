package com.example.labsnewcourse.repository;

import com.example.labsnewcourse.model.EmployeeDocumentRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisObjectRepository extends CrudRepository<EmployeeDocumentRedis, String> {
}

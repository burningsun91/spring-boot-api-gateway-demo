package com.suraj.department.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.suraj.department.service.model.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, Long>{

}

package com.suraj.employee.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.suraj.employee.service.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{

}

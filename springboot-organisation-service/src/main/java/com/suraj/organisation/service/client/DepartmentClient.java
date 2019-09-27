package com.suraj.organisation.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.suraj.organisation.service.model.Department;

@FeignClient(name = "department-service")
public interface DepartmentClient {
	
	@GetMapping(path = "/department/organization/{organizationId}")
	public ResponseEntity<List<Department>> findByOrganisation(@PathVariable("organizationId") Long organizationId);
	
	@GetMapping(path = "/department/organization/{organizationId}/with-employees")
	public ResponseEntity<List<Department>> findByOragnisationWithEmployees(@PathVariable("organizationId") Long organizationId);

}

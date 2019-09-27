package com.suraj.organisation.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.organisation.service.client.DepartmentClient;
import com.suraj.organisation.service.client.EmployeeClient;
import com.suraj.organisation.service.model.Organisation;
import com.suraj.organisation.service.repository.OrganisationRepository;

@RestController
@RequestMapping(path = "/organisation")
public class OrganisationController {
	
	@Autowired
	private OrganisationRepository organisationRepository;
	
	@Autowired
	private DepartmentClient departmentClient;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Organisation>> getAllOrganisations(){
		return ResponseEntity.ok(organisationRepository.findAll());
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<Organisation> addNewOrganisation(@RequestBody Organisation organisation){
		return ResponseEntity.ok(organisationRepository.save(organisation));
	}
	
	@GetMapping(path = "/{organisationId}")
	public ResponseEntity<Organisation> getOrganisation(@PathVariable("organisationId") Long organisationId){
		Optional<Organisation> organisation = organisationRepository.findById(organisationId);
		return ResponseEntity.ok(organisation.get());
	}
	
	@GetMapping(path = "/{organisationId}/with-departments")
	public ResponseEntity<Organisation> getOrganisationWithDepartments(@PathVariable("organisationId") Long organisationId){
		Optional<Organisation> optionalOrg = organisationRepository.findById(organisationId);
		Organisation organisation = optionalOrg.get();
		organisation.setDepartments(departmentClient.findByOrganisation(organisationId).getBody());
		return ResponseEntity.ok(organisation);
	}
	
	@GetMapping(path = "/{organisationId}/with-employees-and-department")
	public ResponseEntity<Organisation> getOrganisationWithEmployeesAndDepartment(@PathVariable("organisationID") Long organisationID){
		Optional<Organisation> optionalOrg = organisationRepository.findById(organisationID);
		Organisation organisation = optionalOrg.get();
		organisation.setDepartments(departmentClient.findByOragnisationWithEmployees(organisationID).getBody());
		return ResponseEntity.ok(organisation);
	}
	
	@GetMapping(path = "/organisationId}/with-employees")
	public ResponseEntity<Organisation> getOrganisationsWithEmployees(@PathVariable("organisationID") Long organisationId){
		Optional<Organisation> optionalOrg = organisationRepository.findById(organisationId);
		Organisation organisation = optionalOrg.get();
		organisation.setEmployees(employeeClient.findByOrganisation(organisationId).getBody());
		return ResponseEntity.ok(organisation);
	}

}

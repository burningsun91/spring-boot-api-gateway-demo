package com.suraj.organisation.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.suraj.organisation.service.model.Organisation;

@Repository
public interface OrganisationRepository extends MongoRepository<Organisation,Long>{

}

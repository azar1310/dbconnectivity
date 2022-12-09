package com.dbconnectivity.dbconnectivity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dbconnectivity.dbconnectivity.model.FinEmpDTO;

@Repository
public interface FinEmpRepo extends MongoRepository<FinEmpDTO, String> {

}

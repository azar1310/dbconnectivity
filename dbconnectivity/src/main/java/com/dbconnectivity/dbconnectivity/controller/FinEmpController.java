package com.dbconnectivity.dbconnectivity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbconnectivity.dbconnectivity.model.FinEmpDTO;
import com.dbconnectivity.dbconnectivity.repository.FinEmpRepo;

@RestController
public class FinEmpController {

	@Autowired
	private FinEmpRepo finRepo;
	
	@GetMapping("/api/Employees")
	public ResponseEntity<?> getAllEmps() {
		List<FinEmpDTO> emps = finRepo.findAll();
		if (emps.size() > 0) {
			return new ResponseEntity<List<FinEmpDTO>>(emps, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No Data available !!", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/api/Employees")
	public ResponseEntity<?> createEmp(@RequestBody FinEmpDTO finemp){
		try {
			finRepo.save(finemp);
			return new ResponseEntity<FinEmpDTO>(finemp, HttpStatus.OK);
		    }
		catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}











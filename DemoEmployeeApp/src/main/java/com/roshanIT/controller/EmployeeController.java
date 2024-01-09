package com.roshanIT.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roshanIT.comp.EmployeeComponent;
import com.roshanIT.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody EmployeeComponent comp ){
		
		String str = service.saveEmployee(comp);
		
		return new ResponseEntity<>(str,HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeleteUser(@PathVariable("id") String id ){
		
		String str = service.deleteEmployee(Integer.parseInt(id));
		
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
	
	@GetMapping("/emplist")
	public ResponseEntity<List> getEmpList(){
		return new ResponseEntity<>(service.getListOfEmployee(),HttpStatus.OK);
	}
	
	
}

package com.roshanIT.service;

import java.util.List;

import com.roshanIT.comp.EmployeeComponent;
import com.roshanIT.entity.EmployeeEntity;

public interface EmployeeService {
	
	public String saveEmployee(EmployeeComponent comp);
	public String deleteEmployee(Integer id);
	public List<EmployeeEntity> getListOfEmployee();
	
	public String updateEmployee(Integer id);
	
}

package com.roshanIT.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshanIT.comp.EmployeeComponent;
import com.roshanIT.entity.EmployeeEntity;
import com.roshanIT.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public String saveEmployee(EmployeeComponent comp) {
		
	if(comp.getEmpId()!=null) {
			EmployeeEntity referenceById = repo.getReferenceById(comp.getEmpId());
			BeanUtils.copyProperties(comp, referenceById);
			referenceById.setEmpStatus("ACTIVE");
			repo.save(referenceById);
			return "Employee Data Updated";
		}else {
			EmployeeEntity en = new EmployeeEntity();
			en.setEmpName(comp.getEmpName());
			en.setEmpSal(comp.getEmpSal());
			en.setEmpDept(comp.getEmpDept());
			repo.save(en);
			return " Employee Data Saved";
		}
	
	}

	@Override
	public String deleteEmployee(Integer id) {
		EmployeeEntity referenceById = repo.getReferenceById(id);
		if(referenceById!=null) {
			repo.delete(referenceById);
			return "User Found And removed";
		}
		else {
			return "User not found";
		}
	}

	@Override
	public List<EmployeeEntity> getListOfEmployee() {
		return repo.findAll();
	}

	@Override
	public String updateEmployee(Integer id) {
		
		EmployeeEntity referenceById = repo.getReferenceById(id);
		referenceById.setEmpName(null);
		
		
		
		
		
		
		
		return null;
	}

}

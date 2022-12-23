package com.tutflix.tutflix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutflix.tutflix.model.clsEmployee;

@Service
public interface EmployeeService {
	
	//save an employee 
	
	clsEmployee addEmployee(clsEmployee employee) ; 

	//get employee 
	 List<clsEmployee> getAllEmployee();
	 
	// get one employee 
	clsEmployee findById(Integer id);
	// update employee
	void updateEmploye(clsEmployee employee);
	
	//delete employee 
	boolean deleteById(Integer id);
	

}

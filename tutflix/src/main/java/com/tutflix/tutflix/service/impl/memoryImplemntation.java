package com.tutflix.tutflix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tutflix.tutflix.model.clsEmployee;
import com.tutflix.tutflix.repository.clsRepoMemory;
import com.tutflix.tutflix.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Qualifier(value = "InMemory")
public class memoryImplemntation implements EmployeeService {

	@Autowired
	private final clsRepoMemory inMemoryEmployeeRepository;

	@Override
	public clsEmployee addEmployee(clsEmployee employee) {
 		return inMemoryEmployeeRepository.addEmployee(employee);
			
	}

	@Override
	public List<clsEmployee> getAllEmployee() {
		return inMemoryEmployeeRepository.getAllEmployee();
	}

	@Override
	public clsEmployee findById(Integer id) {
		return inMemoryEmployeeRepository.findById(id);
	}

	@Override
	public void updateEmploye(clsEmployee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteById(Integer id) {
		return inMemoryEmployeeRepository.deleteById(id);
	}
	
	 

}

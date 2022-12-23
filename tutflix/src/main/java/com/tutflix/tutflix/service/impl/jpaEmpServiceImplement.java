package com.tutflix.tutflix.service.impl;

import java.util.List;
 
 import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tutflix.tutflix.model.clsEmployee;
import com.tutflix.tutflix.repository.JpaEmployeeRepository;
import com.tutflix.tutflix.service.EmployeeService;

 

@Service
@Qualifier(value = "mysqlEmpService")
public class jpaEmpServiceImplement implements EmployeeService  {

	private final JpaEmployeeRepository jepEmp;
	
	public jpaEmpServiceImplement(JpaEmployeeRepository jepEmp)
	{
		this.jepEmp = jepEmp;
	}
	

	@Override
	public clsEmployee addEmployee(clsEmployee employee) {
		// TODO Auto-generated method stub
		return jepEmp.save(employee);
	}
	
	public clsEmployee addEmployee2(clsEmployee employee) {
		return jepEmp.save(employee);
	}

	@Override
	public List<clsEmployee> getAllEmployee() {
		// TODO Auto-generated method stub
		return jepEmp.findAll();
	}

	@Override
	public clsEmployee findById(Integer id) {
		// TODO Auto-generated method stub
		return jepEmp.findById(id).get();
	}

	@Override
	public void updateEmploye(clsEmployee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
	    jepEmp.deleteById(id);
		return true;
	}

}

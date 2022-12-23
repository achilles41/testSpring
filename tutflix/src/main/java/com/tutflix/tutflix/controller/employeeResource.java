package com.tutflix.tutflix.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tutflix.tutflix.model.clsEmployee;
import com.tutflix.tutflix.service.EmployeeService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/v1")
public class employeeResource {
	
	
	private final EmployeeService empService;
	
	public employeeResource(@Qualifier(value = "mysqlEmpService") EmployeeService empService)
	{
		this.empService = empService;
	}
	
	
	@GetMapping("/allEmp")
	public ResponseEntity<List<clsEmployee>> getEmployees(){
		return ResponseEntity.ok(empService.getAllEmployee());
		
	}
	
	@GetMapping("/allEmp/{id}")
	public ResponseEntity<clsEmployee> getEmployeesbyId(@PathVariable("id") Integer id){
		return ResponseEntity.ok(empService.findById(id));
		
	}
	
	
	@PostMapping("/saveEmp")
	public ResponseEntity<clsEmployee> addEmployee(@RequestBody clsEmployee emp ){
		emp.setId(empService.getAllEmployee().size() + 1);
		return ResponseEntity.created(getLoction(emp.getId())).body(empService.addEmployee(emp));
		
	}
	
	@PostMapping("/saveEmp2")
	public clsEmployee addEmployee2(@RequestBody clsEmployee emp ){
		 
		return   empService.addEmployee(emp);
		
	}


	private URI getLoction(int id) {
 		return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
 				.buildAndExpand(id)
 				.toUri();
	}
	
	
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<Boolean> deleteEmp(@PathVariable("id") Integer id){
		return ResponseEntity.ok(empService.deleteById(id));
		
	}


}

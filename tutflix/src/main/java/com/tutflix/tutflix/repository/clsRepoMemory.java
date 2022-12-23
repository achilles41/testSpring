package com.tutflix.tutflix.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutflix.tutflix.model.clsEmployee;


@Repository
public class clsRepoMemory {
	
	
	private static final List<clsEmployee> database = new ArrayList<>();
	
	//we want to initialize some employee
	static {
		database.add(new clsEmployee(1,"asl","ejd","ko"));
	}
	
	
	
	public clsEmployee addEmployee(clsEmployee employee) {
		database.add(employee);
		return employee;
	} 

	public List<clsEmployee> getAllEmployee(){
 		return List.copyOf(database);
 	} 
	 
	public clsEmployee findById(Integer id){
		return database
				.stream()
				.filter(emp -> id.equals(emp.getId()) )
				.findFirst().orElseThrow();
	} 
 	
	public void updateEmploye(clsEmployee employee){
		
	} 
	
	public boolean deleteById(Integer id){
 		clsEmployee emp1 = database
 				.stream()
 				.filter(emp -> id.equals(emp.getId()) )
 				.findFirst()
 				.orElseThrow();
 		database.remove(emp1);
 		return true;
 		
 		
	} 

}

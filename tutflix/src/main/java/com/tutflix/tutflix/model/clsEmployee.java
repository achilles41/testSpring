package com.tutflix.tutflix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class clsEmployee {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String surname;
	
	private String city;
	
	

}

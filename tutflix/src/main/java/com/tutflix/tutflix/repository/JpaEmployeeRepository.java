package com.tutflix.tutflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutflix.tutflix.model.clsEmployee;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<clsEmployee, Integer> {

}

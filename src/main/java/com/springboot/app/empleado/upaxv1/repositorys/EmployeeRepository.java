package com.springboot.app.empleado.upaxv1.repositorys;

import java.util.HashMap;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.app.empleado.upaxv1.models.Employee;

@Repository

public interface EmployeeRepository extends  JpaRepository<Employee, Long>{

	

	@Query("SELECT u FROM Employee u WHERE u.name = ?1")
	public Optional<?> Name(String name);
	
	@Query("SELECT u FROM Employee u WHERE u.last_name = ?1")
	public Optional<?> LastName(String last_name);
	
	@Query("SELECT u FROM Employee u WHERE u.id = ?1")
	public Optional<?> employeeExist(Integer id);
	
	
}
 
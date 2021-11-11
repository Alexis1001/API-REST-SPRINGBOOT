package com.springboot.app.empleado.upaxv1.services;

import java.util.HashMap;
import java.util.Optional;

import com.springboot.app.empleado.upaxv1.models.Employee;

public interface IEmployeeService {

	public Employee addEmployee(Employee employee);

	public Optional<?> FindByName(String name);
	
	public Optional<?> FinByLastName(String lastName);
	
	public Optional<?> FindGenderById(Integer id);

	public Optional<?> FindJobById(Integer id);
	
	public Optional<?> employeeExist(Integer id);

}

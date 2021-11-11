package com.springboot.app.empleado.upaxv1.services;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.empleado.upaxv1.models.Employee;
import com.springboot.app.empleado.upaxv1.models.EmployeeWorkedHour;
import com.springboot.app.empleado.upaxv1.repositorys.EmployeeRepository;
import com.springboot.app.empleado.upaxv1.repositorys.GenderRepository;
import com.springboot.app.empleado.upaxv1.repositorys.JobRepository;
import com.springboot.app.empleado.upaxv1.repositorys.WrokedHoursRepository;

@Service
public class EmployeeServices implements IEmployeeService{
	

	@Autowired EmployeeRepository employeeRepository;
	@Autowired WrokedHoursRepository wrokedHoursRepository; 
	@Autowired JobRepository jobRepository;
	@Autowired GenderRepository genderRepository;
	
	@Override
	public Optional<?> FindByName(String name) {
		
		Optional<?> _name=this.employeeRepository.Name(name);
		System.out.println("el nombre del empleado es  "+_name);
		return _name;
	}


	@Override
	public Optional<?> FinByLastName(String last_name){
		Optional<?> _lastName=this.employeeRepository.LastName(last_name);
		System.out.println("el nombre del empleado es  "+_lastName);
		return _lastName;
	}

	@Override
	public Optional<?> FindJobById(Integer id) {
		Optional<?> _job=Optional.ofNullable(this.jobRepository.JobId(id));
		return _job;
	}


	@Override
	public Optional<?> FindGenderById(Integer id) {
		Optional<?> _gender=Optional.ofNullable(this.genderRepository.GenderId(id));
		return _gender;
	}


	@Override
	public Employee addEmployee(Employee employee) {
		Employee _employee=this.employeeRepository.save(employee);
		return _employee;
	}


	@Override
	public Optional<?> employeeExist(Integer id) {
		Optional<?> _employeeExist=this.employeeRepository.employeeExist(id);
		return _employeeExist;
	}
	
	public EmployeeWorkedHour employeeWorked(EmployeeWorkedHour employeeWorked){
		EmployeeWorkedHour _employeeWorked=this.wrokedHoursRepository.save(employeeWorked);
		return _employeeWorked;
	}
	
	
	
}

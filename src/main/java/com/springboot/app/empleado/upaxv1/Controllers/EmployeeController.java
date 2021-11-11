package com.springboot.app.empleado.upaxv1.Controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import com.springboot.app.empleado.upaxv1.models.Employee;
import com.springboot.app.empleado.upaxv1.models.EmployeeWorkedHour;
import com.springboot.app.empleado.upaxv1.services.EmployeeServices;

@RestController
@RequestMapping("/api")

public class EmployeeController {
	
	
	@Autowired private EmployeeServices employeeService;
	
	@PostMapping(value = "/employees")
	public ResponseEntity<HashMap<String, String>> addEmployee( @RequestBody(required = true) Employee employee) throws ParseException {
		System.out.println("el empleado es "+employee);
		this.getCalculateEge(employee.getBirthdate());
		boolean Name=this.NameExist(employee.getName());
		boolean lastName=this.LastNameExist(employee.getLast_name());
		boolean isOlder=this.getCalculateEge(employee.getBirthdate());
		Integer jobId=employee.getJob_id();
		boolean job=this.JobExist(jobId);
		Integer GenderId=employee.getGender_id();
		boolean gender=this.GenderExist(GenderId);
		if(!Name && !lastName && isOlder && gender && job) {
			//System.out.println("insertar ");
			this.employeeService.addEmployee(employee);
			
			return ResponseEntity.status(HttpStatus.OK).body(this.responseBody(jobId,"success",true));
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(this.responseBody(jobId,"success",false));
		}
		
	}
	/*	Se debe validar que el empleado exista, 
	 * que el total de horas trabajadas no sea mayor a 20 horas y
		que la fecha de trabajo sea menor o igual a la actual y */
	 
	@PostMapping(value = "/employees/worked-hours")
	
	public ResponseEntity<HashMap<String,String>> workerdHours( @RequestBody(required = true) EmployeeWorkedHour employeeWorked ){
		System.out.println("trabajado "+employeeWorked);
		boolean exist=this.employeeExiste(employeeWorked.getEmployee_id());
		System.out.println("el usuario existe "+exist);
		boolean isLess=this.compareDate(employeeWorked.getWorked_date());
		if(exist && employeeWorked.getWorked_hours()<20 && isLess) {
			this.employeeService.employeeWorked(employeeWorked);
			return ResponseEntity.status(HttpStatus.OK).body(this.responseBody(employeeWorked.getEmployee_id(),"success",true));
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(this.responseBody(employeeWorked.getEmployee_id(),"success",false));
		}
		
	}
	
	
	public HashMap<String,String> responseBody(Integer id,String key,  boolean data) {
		HashMap<String,String> response = new HashMap<String,String>();
		response.put("id",String.valueOf(id));
		response.put(key,String.valueOf(data));
		
		return response;
	}
	
	public boolean employeeExiste(Integer employeeId) {
		Optional<?> employee=this.employeeService.employeeExist(employeeId);
		if(employee.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	} 
	
	public boolean compareDate(Date dateWork) {
		Date currentDate=new Date();
		long current_date=currentDate.getTime();
		System.out.println("fecha de horas trabajadas "+dateWork.getTime());
		System.out.println("fecha actual "+current_date);
		if(dateWork.getTime()<=current_date) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public boolean getCalculateEge(Date date) throws ParseException {
		Date currentDate=new Date();
		int currentYear=currentDate.getYear()+1900;
		System.out.println("fecha actual "+currentYear);
		int birthdate=date.getYear()+1900;
		System.out.println("fecha nacimineto "+birthdate);
		System.out.println("el date es "+date);
		int result=currentYear-birthdate;
		System.out.println("result "+result);
		if(result<18) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean NameExist(String name) {
		Optional<?> _name=this.employeeService.FindByName(name);
		if(_name.isEmpty()) {
			System.out.println("No Encontrado name");
			return false;
		}
		else {
			return true;
		}
	
	}
	
	public boolean LastNameExist(String LastName) {
		Optional<?> _lastName=this.employeeService.FinByLastName(LastName);
		if(_lastName.isEmpty()) {
			System.out.println("No encontrado lastName");
			return false ;
		}
		else {
			return true;
		}
	}
	
	public boolean JobExist(Integer id) {
		Optional<?> _job=this.employeeService.FindJobById(id);
		if(_job.isEmpty()) {
			System.out.println("No Encontrado job");
			return false;
		}
		else {
			return true;
		}
	
	}
	
	public boolean GenderExist(Integer id) {
		Optional<?> _gender=this.employeeService.FindGenderById(id);
		if(_gender.isEmpty()) {
			System.out.println("No Encontrado gender");
			return false;
		}
		else {
			return true;
		}
	
	}
	
	
}








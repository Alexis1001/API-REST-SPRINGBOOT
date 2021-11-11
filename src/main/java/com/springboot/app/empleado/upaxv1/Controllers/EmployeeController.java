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
import com.springboot.app.empleado.upaxv1.services.EmployeeServices;

@RestController
@RequestMapping("/api")

public class EmployeeController {
	
	
	@Autowired private EmployeeServices employeeService;
	
	@PostMapping(value = "/employees")
	public ResponseEntity<HashMap<String, String>> addEmployee( @RequestBody(required = true) Employee employee) throws ParseException {
		
		Date date=employee.getBirthDate();
		boolean Name=this.NameExist(employee.getName());
		boolean lastName=this.LastNameExist(employee.getLastName());
		boolean isNotOlder=this.getCalculateEge(date);
		
		Integer jobId=employee.getJob_id();
		boolean job=this.JobExist(jobId);
		Integer GenderId=employee.getGender_id();
		boolean gender=this.GenderExist(GenderId);
		
		
		if(!Name && !lastName && isNotOlder && gender && job) {
			//System.out.println("insertar ");
			//this.employeeService.addEmployee(employee)
			Employee _employee =new Employee();
			_employee.setName(employee.getName());
			_employee.setLastName(employee.getLastName());
			_employee.setBirthDate(employee.getBirthDate());
			_employee.setGender_id(employee.getGender_id());
			_employee.setJob_id(employee.getJob_id());
			
			this.employeeService.addEmployee(_employee);
			
			return ResponseEntity.status(HttpStatus.OK).body(this.responseBody(jobId,"success",true));
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(this.responseBody(jobId,"success",false));
		}
		
		
		
	}
	
	public HashMap<String,String> responseBody(Integer id,String key,  boolean data) {
		HashMap<String,String> response = new HashMap<String,String>();
		response.put("id",String.valueOf(id));
		response.put(key,String.valueOf(data));
		
		return response;
	}
	
	
	public boolean getCalculateEge(Date date) throws ParseException {
		//Calendar calendar=Calendar.getInstance();
		//Date currentDate=calendar.getTime();
		
		Date dt=new Date();
        int year=dt.getYear();
        int current_Year=year+1900;
        int anio=date.getYear();
        
        System.out.println("año actual  "+current_Year);
        System.out.println("año nacimiento "+anio);
        SimpleDateFormat getYearFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentYear = getYearFormat.format(date);
        System.out.println("ano de nacimiento"+currentYear);
        
        String fecha=date.getYear()+"/"+date.getMonth()+"/"+date.getDay();
        System.out.println("la fecha es "+fecha);
        //Calendar calendar=calendar.getInstance();
        
        Date d=new Date();  
        int yeaxr=d.getYear()+1900;
        
        int x=date.getYear()+1900;
        System.out.println("Year for date object is : "+date.getYear());
        System.out.println("Year for date object is : "+x);  
   
        
     /*
		String _date[]=date.split("-");
		int anio=Integer.parseInt(_date[0]);
		int currentAnio= current_Year;
		int result=currentAnio-anio;
		if(result<18) {
			return false;
		}
		else {
			return true;
		}*/
		return true;
		
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








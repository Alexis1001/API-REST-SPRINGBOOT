package com.springboot.app.empleado.upaxv1.models;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_worked_hours")
public class EmployeeWorkedHour implements Serializable {
	private static final long serialVersionUID = -2381191613109404417L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name="employee_id")
	Long employeeId;
	
	@Column(name="worked_hours")
	Long workedHours;
	
	@Column(name="worked_date")
	private Date workedDate = new Date();

	public EmployeeWorkedHour() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(Long workedHours) {
		this.workedHours = workedHours;
	}

	public Date getWorkedDate() {
		return workedDate;
	}

	public void setWorkedDate(Date workedDate) {
		this.workedDate = workedDate;
	}
	
}
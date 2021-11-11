package com.springboot.app.empleado.upaxv1.models;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="employee_worked_hours")
public class EmployeeWorkedHour implements Serializable {
	private static final long serialVersionUID = -2381191613109404417L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name="employee_id")
	Integer employee_id;
	
	@Column(name="worked_hours")
	Integer worked_hours;
	
	@Column(name="worked_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date worked_date;

	public EmployeeWorkedHour() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public Integer getWorked_hours() {
		return worked_hours;
	}

	public void setWorked_hours(Integer worked_hours) {
		this.worked_hours = worked_hours;
	}

	public Date getWorked_date() {
		return worked_date;
	}

	public void setWorked_date(Date worked_date) {
		this.worked_date = worked_date;
	}

	@Override
	public String toString() {
		return "EmployeeWorkedHour [id=" + id + ", employee_id=" + employee_id + ", worked_hours=" + worked_hours
				+ ", worked_date=" + worked_date + "]";
	}
	
	
	

	
	
}
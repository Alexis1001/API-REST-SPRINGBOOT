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
@Table(name="employees")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -2381191613109404417L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name="gender_id")
	private Integer genderId;
	
	@Column(name="job_id")
	private Integer jobId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birthdate")
	private Date birthDate = new Date();
	
	public Employee(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGender_id() {
		return genderId;
	}

	public void setGender_id(Integer genderId) {
		this.genderId = genderId;
	}

	public Integer getJob_id() {
		return jobId;
	}

	public void setJob_id(Integer job_id) {
		this.jobId= jobId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}


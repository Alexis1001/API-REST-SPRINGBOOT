package com.springboot.app.empleado.upaxv1.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.app.empleado.upaxv1.models.EmployeeWorkedHour;

@Repository
public interface WrokedHoursRepository extends JpaRepository<EmployeeWorkedHour,Long> {
	
}

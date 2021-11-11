package com.springboot.app.empleado.upaxv1.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.app.empleado.upaxv1.models.Job;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job,Long>{
	@Query("SELECT u FROM Job u WHERE u.id = ?1")
	public Optional<?> JobId( Integer id);
	
}

package com.springboot.app.empleado.upaxv1.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.app.empleado.upaxv1.models.Gender;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;


@Repository
public interface GenderRepository extends JpaRepository<Gender,Long> {
	@Query("SELECT u FROM Gender u WHERE u.id = ?1")
	public Optional<?> GenderId(Integer id);
}

package com.pucmg.authenticationcore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pucmg.authenticationcore.entities.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
	@Query("select e from RoleEntity e where e.description = :role")
	RoleEntity findByCode(@Param("role") String role);

}

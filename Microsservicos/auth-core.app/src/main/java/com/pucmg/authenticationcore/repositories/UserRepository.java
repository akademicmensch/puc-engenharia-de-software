package com.pucmg.authenticationcore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pucmg.authenticationcore.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	void addUser(UserEntity user);
	
	@Query("select e from UserEntity e where e.code = :username")
	UserEntity findByCode(@Param("username") String username);

}

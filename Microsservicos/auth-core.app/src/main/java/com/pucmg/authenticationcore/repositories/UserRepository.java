package com.pucmg.authenticationcore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucmg.authenticationcore.entities.UserEntity;
import com.pucmg.authenticationcore.models.SampleUser;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	void addUser(SampleUser user);

}

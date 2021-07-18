package com.pucmg.authenticationcore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucmg.authenticationcore.entities.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{

}

package com.pucmg.projectcore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucmg.projectcore.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}

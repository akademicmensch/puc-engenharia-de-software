package com.pucmg.projectcore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucmg.projectcore.entities.ActivityEntity;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Long>{

}

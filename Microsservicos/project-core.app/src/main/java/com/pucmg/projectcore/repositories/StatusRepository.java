package com.pucmg.projectcore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucmg.projectcore.entities.StatusEntity;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long>{

	StatusEntity findByDescription(String string);

}

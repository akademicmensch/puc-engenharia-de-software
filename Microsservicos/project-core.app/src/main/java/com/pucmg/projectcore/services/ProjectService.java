package com.pucmg.projectcore.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucmg.projectcore.entities.ProjectEntity;
import com.pucmg.projectcore.entities.StatusEntity;
import com.pucmg.projectcore.entities.UserEntity;
import com.pucmg.projectcore.models.CreateProject;
import com.pucmg.projectcore.repositories.ProjectRepository;
import com.pucmg.projectcore.repositories.StatusRepository;
import com.pucmg.projectcore.repositories.UserRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private UserRepository userRepository;

	public List<ProjectEntity> getOngoingProjects() {
		return projectRepository.findAll();
	}

	public boolean createProject(CreateProject form) {
		boolean retorno = true;
		ProjectEntity entity = new ProjectEntity();
		entity.setColor("GREEN");
		entity.setDescription(form.getDescription());
		entity.setIdentification(form.getCode());
		StatusEntity s = statusRepository.findByDescription("INCEPTION");
		entity.setStatus(s);
		entity.setAssociates(transformIdsToEntities(form.getAssociates()));
		
		if(form.getBegin() == null) {
			entity.setBegin(new Date());
		}else {
			entity.setBegin(form.getBegin());
		}
		entity.setEnd(form.getEnd());
		
		try {projectRepository.save(entity);}catch(Exception e) {
			retorno = false;
		}
		
		return retorno;
	}

	private List<UserEntity> transformIdsToEntities(List<Long> associates) {
		List<UserEntity> retorno = null;
		if(associates != null) {
			for(Long id : associates) {
				Optional<UserEntity> findById = userRepository.findById(id);
				if(findById.isPresent()) {
					retorno.add(findById.get());
				}	
			}
		}
		return retorno;
	}

}

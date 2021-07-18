package com.pucmg.notificationcore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucmg.notificationcore.entities.NotificationEntity;
import com.pucmg.notificationcore.integrations.models.Activity;
import com.pucmg.notificationcore.integrations.models.ProjectModelDTO;
import com.pucmg.notificationcore.integrations.service.ProjectClientService;
import com.pucmg.notificationcore.repositories.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository repo;
	
	@Autowired
	private ProjectClientService projectCoreIntegration;
	
	@Autowired
	private SendEmailService emailService;

	public void runTaskSequence() {
		//Verifica registro 1 da tabela de notificacao
		Optional<NotificationEntity> findById = repo.findById(1L);
		
		if(findById.isPresent()) {
			//Parametros configurados para envio do email
			String notificationTaskParameters = findById.get().getNotificationParameters();
			
			
			//Verificar tarefas existentes em aberto(endpoint fornecido por project-core.app)
			List<Activity> findOngoingActivities = projectCoreIntegration.findOngoingActivities();
			
			//Realizar a verificacao de data de inicio e fim e, de acordo com o resultado,
			List<Activity> toSendEmail = verifyActivityDelay(findOngoingActivities);
			//realizar a persistencia da cor verde/vermelha na tabela de Atividade
			updateActivitiesToRedColor(toSendEmail);
			//Para projetos em atraso, enviar email de notificacao para o funcionario responsavel
			sendMailToAssociates(toSendEmail, notificationTaskParameters);
		}
	}

	public void runProjectSequence() {
		//Verifica registro 2 da tabela de notificacao
		Optional<NotificationEntity> findById = repo.findById(2L);
		
		if(findById.isPresent()) {
			//Parametros configurados para envio do email
			String notificationProjectParameters = findById.get().getNotificationParameters();
			
			//Verificar projetos existentes em aberto(endpoint fornecido por project-core.app)
			List<ProjectModelDTO> findOngoingProjects = projectCoreIntegration.findOngoingProjects();
			
			//Realizar a verificacao de data de inicio e fim e, de acordo com o resultado,
			List<ProjectModelDTO> toSendEmail = verifyDelay(findOngoingProjects);
			//realizar a persistencia da cor verde/vermelha na tabela de Projeto
			updateProjectsToRedColor(toSendEmail);
			//Para projetos em atraso, enviar email de notificacao para o gerente responsavel
			sendMailToManagers(toSendEmail, notificationProjectParameters);
		}
		
	}

	private void sendMailToManagers(List<ProjectModelDTO> toSendEmail, String notificationProjectParameters) {
		
		for(ProjectModelDTO project : toSendEmail) {
			String parametersToSend = project.getId() + project.getProjectIdentification() + project.getBegin() + project.getEnd();
			String parameters = bindInfoToTemplate(notificationProjectParameters, parametersToSend);
			emailService.sendEmail(project.getProjectManager().getEmail(), parameters);
		}
	}
	
	private void sendMailToAssociates(List<Activity> toSendEmail, String notificationTaskParameters) {
		for(Activity activity : toSendEmail) {
			String parametersToSend = activity.getId() + activity.getDescription() + activity.getBegin() + activity.getEnd();
			String parameters = bindInfoToTemplate(notificationTaskParameters, parametersToSend);
			emailService.sendEmail(activity.getAssociate().getEmail(), parameters);
		}
	}

	private String bindInfoToTemplate(String notificationProjectParameters, String parametersToSend) {
		//Montando corpo do email com template parametrizado na tabela e informacoes obtidas da base de dados e processadas no microsservico
		return notificationProjectParameters + parametersToSend;
	}

	private void updateProjectsToRedColor(List<ProjectModelDTO> toUpdateColor) {
		for(ProjectModelDTO project : toUpdateColor) {
			projectCoreIntegration.upadteProjectToDelay(project.getId());
		}
	}
	
	private void updateActivitiesToRedColor(List<Activity> toUpdateActivityColor) {
		for(Activity activity : toUpdateActivityColor) {
			projectCoreIntegration.upadteActivityToDelay(activity.getId());
		}
	}
	
	private List<ProjectModelDTO> verifyDelay(List<ProjectModelDTO> findOngoingProjects) {
		return findOngoingProjects;
	}
	private List<Activity> verifyActivityDelay(List<Activity> findOngoingActivities) {
		return findOngoingActivities;
	}
}

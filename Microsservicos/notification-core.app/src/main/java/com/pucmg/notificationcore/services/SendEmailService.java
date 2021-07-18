package com.pucmg.notificationcore.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class SendEmailService {
	
	private static final Logger logger = LoggerFactory.getLogger(SendEmailService.class);
	
	public void sendEmail(String destinatario, String corpoEmail) {
		
		//A implementacao do client de email pode ser vista no momento do refinamento
		logger.info("Email enviado para destinatario {} com o corpo {}", destinatario, corpoEmail);
	}
	
}

package com.pucmg.authenticationcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucmg.authenticationcore.repositories.UserEntityRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserEntityRepository userRepository;
	
	
	
}

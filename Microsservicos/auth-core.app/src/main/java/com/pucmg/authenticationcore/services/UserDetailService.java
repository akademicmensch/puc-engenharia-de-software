package com.pucmg.authenticationcore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.pucmg.authenticationcore.entities.RoleEntity;
import com.pucmg.authenticationcore.entities.UserEntity;
import com.pucmg.authenticationcore.models.SampleUser;
import com.pucmg.authenticationcore.repositories.RoleRepository;
import com.pucmg.authenticationcore.repositories.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity findByCode = userRepository.findByCode(username);
		return new User(findByCode.getCode(), findByCode.getPassword(), retornarAuthority(findByCode.getRole().getDescription()));
	}
	
    public GrantedAuthority obterAuthority(String role) {
    	return new GrantedAuthority() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return role;
			}
		};
    }
    
    public List<GrantedAuthority> retornarAuthority(String role){
    	GrantedAuthority obterAuthority = obterAuthority(role);
    	List<GrantedAuthority> lst = new ArrayList<>();
    	lst.add(obterAuthority);
    	return lst;
    }
    
    public void inputDefaultUsers(SampleUser user){
    	UserEntity entity = new UserEntity();
    	entity.setCode(user.getName());
    	entity.setEmail(user.getName());
    	entity.setName(user.getName());
    	entity.setPassword("default");
    	RoleEntity role = roleRepository.findByCode(user.getRole());
    	entity.setRole(role);
    	userRepository.saveAndFlush(entity);
    }
    
    public SampleUser retornarUsuarioERole(String user) {
    	UserEntity findByCode = userRepository.findByCode(user);
    	return new SampleUser(findByCode.getCode(),findByCode.getRole().getDescription());
    }
}

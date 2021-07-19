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
import org.springframework.security.core.userdetails.UserDetails;

import com.pucmg.authenticationcore.models.SampleUser;
import com.pucmg.authenticationcore.repositories.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*

    	List<SampleUser> users = userRepo.getAllUsers();
    	
    	for (SampleUser sampleUser : users) {
    		if(s.equalsIgnoreCase("usuario1")) {
    			return new User("usuario1", "guilherme123", retornarAuthority(sampleUser.getRole()));
        	}else if(s.equalsIgnoreCase("usuario2")) {
        		return new User("usuario2", "admin", new ArrayList<>());
        	}else if(s.equalsIgnoreCase("consultoria.um")) {
        		return new User("consultoria.um", "consultoria.um", new ArrayList<>());
        	}
		}

		 * */
		return null;
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
    	userRepository.addUser(user);
    }
    
    
    public SampleUser retornarUsuarioERole(String user) {
    	SampleUser u = new SampleUser();
    	if(user.equalsIgnoreCase("admin")) {
    		u = new SampleUser("admin","admin");
    	}else if(user.equalsIgnoreCase("guilherme.batista")) {
    		u = new SampleUser("guilherme.batista","admin");
    	}else if(user.equalsIgnoreCase("consultoria.um")) {
    		u = new SampleUser("consultoria.um","consultoria");
    	}else if(user.equalsIgnoreCase("consultoria.dois")) {
    		u = new SampleUser("consultoria.dois","consultoria");
    	}else if(user.equalsIgnoreCase("funcionario.generico")) {
    		u = new SampleUser("funcionario.generico","funcionario");
    	}
    	return u;
    }

}

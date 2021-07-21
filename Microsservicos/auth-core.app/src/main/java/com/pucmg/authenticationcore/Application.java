package com.pucmg.authenticationcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/*	@Bean
	public CommandLineRunner sampleData(MyUserDetailsService userService) {
		return (args) -> {
			userService.inputDefaultUsers(new SampleUser("admin","manager"));
			userService.inputDefaultUsers(new SampleUser("joao","associate"));
		};
	}*/

}

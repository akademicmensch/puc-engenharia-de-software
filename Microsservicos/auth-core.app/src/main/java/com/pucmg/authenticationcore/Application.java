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
			userService.inputDefaultUsers(new SampleUser("admin","admin"));
			userService.inputDefaultUsers(new SampleUser("guilherme.batista","admin"));
			userService.inputDefaultUsers(new SampleUser("consultoria.um","consultoria"));
			userService.inputDefaultUsers(new SampleUser("consultoria.dois","consultoria"));
			userService.inputDefaultUsers(new SampleUser("funcionario.generico","funcionario"));
		};
	}*/

}

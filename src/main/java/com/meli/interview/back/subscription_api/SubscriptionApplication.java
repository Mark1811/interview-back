package com.meli.interview.back.subscription_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubscriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionApplication.class, args);
	}


/*
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
             Role rol = new Role("ADMIN");
			userService.saveRole(rol);
			User user	=new User("facundo","facundo","pass",null);
			userService.save(user);
			userService.addRoleToUser("facundo","ADMIN");
		};
	}
*/



}

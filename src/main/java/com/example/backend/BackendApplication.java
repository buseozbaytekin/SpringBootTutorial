package com.example.backend;

import com.example.backend.dto.UserCreateDTO;
import com.example.backend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialUsers(UserService userService){
		return (args) -> {
			UserCreateDTO user = new UserCreateDTO();
			user.setUserName("user1");
			user.setFirstName("Buse");
			user.setLastName("Ozbaytekin");
			userService.createUser(user);

			UserCreateDTO user2 = new UserCreateDTO();
			user2.setUserName("user2");
			user2.setFirstName("Mustafa");
			user2.setLastName("Bilce");
			userService.createUser(user2);

			UserCreateDTO user3 = new UserCreateDTO();
			user3.setUserName("user3");
			user3.setFirstName("Buse");
			user3.setLastName("Bilce");
			userService.createUser(user3);
		};
	}
}

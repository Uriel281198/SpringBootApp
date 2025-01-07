package com.uri.sp.app.springboot_web;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);

		System.out.println("Hola Mundo desde Spring Boot");

		int a = 2;

		List<String> users = Arrays.asList("Uriel", "Pancho", "paco");

		System.out.println(users.isEmpty());

		System.out.println(users.size());

	}

}

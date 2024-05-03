package com.mz.project01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Project01Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Project01Application.class, args);
		
		// instead of making the object like with new and then maintaing i can simply ask the spring for a object 
		Alien obj = context.getBean(Alien.class); // now i need create the method for the object because i can not call the object without a method
		
		obj.code();
	}

}

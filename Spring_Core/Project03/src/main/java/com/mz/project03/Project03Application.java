package com.mz.project03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mz.project03.dav.AlienDav;
import com.mz.project03.model.Alien;

@SpringBootApplication
public class Project03Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Project03Application.class, args);
		
		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(111);
		alien1.setName("MZ");
		alien1.setTech("Java");
		
		AlienDav dav = context.getBean(AlienDav.class);
		dav.save(alien1);
		
		System.out.println(dav.findAll());
		
		
	}

}

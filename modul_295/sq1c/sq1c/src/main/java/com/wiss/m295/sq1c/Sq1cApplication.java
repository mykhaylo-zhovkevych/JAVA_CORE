package com.wiss.m295.sq1c; // Stelle sicher, dass dies das richtige Package ist

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication  // Annotation, die diese Klasse als Spring Boot Anwendung markiert
@RestController // Annotation, die die Klasse als REST-Controller definiert
public class Sq1cApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sq1cApplication.class, args); // Startet die Spring Boot Anwendung
	}

	@GetMapping("/greetings") // Bindet die Methode an GET-Anfragen an die URL "/greetings"
	public ResponseEntity<String> sayHelloWorld() { // Methode, die eine HTTP-Antwort zurückgibt
		return ResponseEntity.ok("Hello World"); // Gibt eine 200 OK Antwort mit dem Text "Hello World" zurück
	}
}

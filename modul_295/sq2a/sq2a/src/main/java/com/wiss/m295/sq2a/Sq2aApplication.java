package com.wiss.m295.sq2a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Sq2aApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sq2aApplication.class, args);

		// GameItemsController aus dem Spring-Kontext abrufen
		GameItemsController controller = context.getBean(GameItemsController.class);

		try {

			System.out.println("Alle Gadget-Datensätze:");
			controller.printGameItems();

			controller.addGameItems("Neues Gadget");

			// Gadget entfernen (hier die ID des zu entfernenden Gadgets angeben)
			controller.removeGameItems(1);

			// Aktualisierte Gadget-Datensätze anzeigen
			System.out.println("Aktualisierte Gadget-Datensätze:");
			controller.printGameItems();
		} catch (Exception e) {
			System.out.println("Datenbank-Zugriff gescheitert");
			e.printStackTrace();
		}
	}
}

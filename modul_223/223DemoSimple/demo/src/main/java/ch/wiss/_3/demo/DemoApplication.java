package ch.wiss._3.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.wiss._3.demo.model.ERole;
import ch.wiss._3.demo.model.Role;
import ch.wiss._3.demo.repository.RoleRepository;


@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			if (roleRepository.count() == 0) {
				roleRepository.save(new Role(ERole.ROLE_USER));
				roleRepository.save(new Role(ERole.ROLE_ADMIN));
		}
	}
}
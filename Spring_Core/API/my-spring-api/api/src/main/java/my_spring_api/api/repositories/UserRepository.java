package my_spring_api.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import my_spring_api.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

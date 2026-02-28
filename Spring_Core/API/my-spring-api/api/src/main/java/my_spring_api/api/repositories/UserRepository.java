package my_spring_api.api.repositories;

import org.springframework.data.repository.CrudRepository;

import my_spring_api.api.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
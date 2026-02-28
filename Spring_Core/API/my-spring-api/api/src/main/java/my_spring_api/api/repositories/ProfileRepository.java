package my_spring_api.api.repositories;

import org.springframework.data.repository.CrudRepository;
import my_spring_api.api.entities.Profile;


public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
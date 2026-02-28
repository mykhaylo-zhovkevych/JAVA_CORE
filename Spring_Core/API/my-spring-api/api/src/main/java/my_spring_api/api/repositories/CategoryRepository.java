package my_spring_api.api.repositories;

import org.springframework.data.repository.CrudRepository;

import my_spring_api.api.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
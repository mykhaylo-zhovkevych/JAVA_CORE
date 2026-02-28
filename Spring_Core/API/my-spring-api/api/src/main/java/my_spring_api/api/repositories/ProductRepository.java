package my_spring_api.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import my_spring_api.api.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // When laoding the Product also load its category relation in the samequery instead of waiting for lazy loading later.
    @EntityGraph(attributePaths = "category")
    List<Product> findByCategoryId(Byte categoryId);

    @EntityGraph(attributePaths = "category")
    @Query("SELECT p FROM Product p")
    List<Product> findAllWithCategory();
}

package main.java.wiss.ch.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Du kannst hier weitere benutzerdefinierte Abfragen hinzufügen, falls notwendig
}
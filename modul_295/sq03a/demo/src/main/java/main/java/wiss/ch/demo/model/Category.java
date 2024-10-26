package main.java.wiss.ch.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id; 

    private String category;

    // Getter und Setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

}

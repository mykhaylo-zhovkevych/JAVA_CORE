package main.java.wiss.ch.demo.controller;

import main.java.wiss.ch.demo.model.Category;
import main.java.wiss.ch.demo.model.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/category")
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path="/")
    public @ResponseBody Integer addCategory(@RequestParam String categoryName) {
        Category c = new Category();
        c.setCategory(categoryName);
        categoryRepository.save(c);
        return c.getId();
    }

    @GetMapping(path="/")
    public @ResponseBody Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
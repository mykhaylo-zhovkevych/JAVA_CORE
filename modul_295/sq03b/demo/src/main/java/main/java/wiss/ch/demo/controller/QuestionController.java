package main.java.wiss.ch.demo.controller;

import main.java.wiss.ch.demo.model.Category;
import main.java.wiss.ch.demo.model.Question;
import main.java.wiss.ch.demo.model.QuestionRepository;
import main.java.wiss.ch.demo.model.CategoryRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CategoryRepository categoryRepository; 

    @PostMapping(path = "/")
    public @ResponseBody Integer addQuestion(@RequestParam String questionText, @RequestParam Integer categoryId) {
        Question question = new Question();
        question.setQuestion(questionText);

        // Verwende die Methode zur Zuweisung der Kategorie
        question.setCategory(findCategoryById(categoryId));

        questionRepository.save(question);
        return question.getId();
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Neue Methode zur Suche nach einer Kategorie
    private Category findCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));
    }
}

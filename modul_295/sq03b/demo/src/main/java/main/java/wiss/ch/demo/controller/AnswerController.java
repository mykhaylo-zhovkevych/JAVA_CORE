package main.java.wiss.ch.demo.controller;

import main.java.wiss.ch.demo.model.Answer;
import main.java.wiss.ch.demo.model.AnswerRepository;
import main.java.wiss.ch.demo.model.Question;
import main.java.wiss.ch.demo.model.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/answer")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping(path = "/")
    public @ResponseBody Integer addAnswer(@RequestParam String answerText, @RequestParam Integer questionId) {
        Answer answer = new Answer();
        answer.setAnswer(answerText);
        
        // Frage suchen und zuweisen
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
        answer.setQuestion(question);
        
        answerRepository.save(answer);
        return answer.getId();
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }
}
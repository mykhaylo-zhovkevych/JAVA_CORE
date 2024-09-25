package com.wiss.m295.sq2b;

import java.util.List;

public class Questions {

    public int id;
    public String text;
    public List<String> answers;
    public String correctAnswer;

    public Questions(int id, String text, List<String> answers, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    // Getter
    public int getId() {
        return this.id;
    }

    public boolean checkAnswer(String givenAnswer) {
        return this.correctAnswer.equals(givenAnswer);
    }

    @Override
    public String toString() {
        return "Text: " + text + ", Answers: " + answers + ", Correct Answer: " + correctAnswer;
    }
}


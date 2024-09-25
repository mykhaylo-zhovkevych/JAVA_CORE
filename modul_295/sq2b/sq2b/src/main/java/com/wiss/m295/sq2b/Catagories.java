package com.wiss.m295.sq2b;

import java.util.List;

public class Catagories {

    public String name;
    public List<Questions> questions;

    public Catagories(String name, List<Questions> questions) {
        this.name = name;
        this.questions = questions;
    }

    // Getter
    public List<Questions> getQuestions() {
        return this.questions;

    }

    public void addQuestion(Questions q) {
        questions.add(q);
    }
}


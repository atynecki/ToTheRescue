package com.rescue.totherescue.model;


import java.util.ArrayList;

public class Quiz {
    private final static int QUESTION_NUMBER = 10;
    private ArrayList<Question> questions;

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Quiz(ArrayList<Question> questions) {

        this.questions = questions;
    }
}

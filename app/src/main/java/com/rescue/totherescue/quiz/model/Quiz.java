package com.rescue.totherescue.quiz.model;


import com.rescue.totherescue.quiz.model.Question;

import java.io.Serializable;
import java.util.ArrayList;

public class Quiz implements Serializable {
    private String name;
    private int question_number;
    private ArrayList<Question> questions;

    public int getWrong_answer() {
        return wrong_answer;
    }

    public void setWrong_answer(int wrong_answer) {
        this.wrong_answer = wrong_answer;
    }

    public int getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(int correct_answer) {
        this.correct_answer = correct_answer;
    }

    private int wrong_answer;
    private int correct_answer;
    
    public Quiz(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
        this.question_number = questions.size();
        this.wrong_answer =  this.question_number;
        this.correct_answer = 0;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public int getQuestion_number() {
        return question_number;
    }

    public void setQuestion_number(int question_number) {
        this.question_number = question_number;
    }

    public void setCorrectAnswer ()
    {
        if(correct_answer < question_number && wrong_answer > 0) {
            correct_answer++;
            wrong_answer--;
        }
    }
}

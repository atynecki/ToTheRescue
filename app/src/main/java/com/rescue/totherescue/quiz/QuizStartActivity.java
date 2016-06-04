package com.rescue.totherescue.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rescue.totherescue.R;
import com.rescue.totherescue.quiz.model.Question;
import com.rescue.totherescue.quiz.model.Quiz;

import java.util.ArrayList;

public class QuizStartActivity extends AppCompatActivity {

    private Button start_button;
    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);

        Intent intent = getIntent();
        String thisCase =  intent.getStringExtra("case");

        //Set quiz class
        quiz = new Quiz(thisCase, new ArrayList<Question>());
        createQuizClass(thisCase);

        //Set case name
        TextView case_name = (TextView) findViewById(R.id.textView_case);
        case_name.setText(thisCase);

        //Set discription
        TextView description = (TextView) findViewById(R.id.textView_description);
        description.setText(getQuizDescription(quiz.getQuestion_number()));

        start_button = (Button) findViewById(R.id.button_start);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizStartActivity.this, QuestionActivity.class);
                intent.putExtra("quiz", quiz);
                startActivity(intent);
                finish();
            }
        });
    }

    private String getQuizDescription(int question_num)
    {
        return "Ten Quiz zawiera "+String.valueOf(question_num)+" pytań. Na udzielenie poprawnej odpowiedzi masz 45 sekund. W przypadku pomyłki wyświetlony zostanie tekst uzupełeniający Twoją wiedzę.";
    }

    private void createQuizClass(String quiz_case)
    {
        ArrayList<Question> questions;

        switch(quiz_case)
        {
            case "Zadławienie":
                questions = setZadlawienia();
                break;
            case "Tonięcie":
                questions = setToniecie();
                break;
            case "Porażenie prądem":
                questions = setPorazenie();
                break;
            case "Oparzenie":
                questions = setOparzenie();
                break;
            case "Rany":
                questions = setRany();
                break;
            case "RKO":
                questions = setRKO();
                break;
            case "Utrata przytomności":
                questions = setPrzytmnosc();
                break;
            case "Zawał":
                questions = setZawal();
                break;
            default:
                questions = null;
                break;
        }
        quiz.setQuestions(questions);
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    private ArrayList<Question> setZadlawienia()
    {
        ArrayList<Question> questions = new ArrayList<>();

        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestion(getString(R.string.ZQ1));
        q1.setOption1(getString(R.string.ZQ1A1));
        q1.setOption2(getString(R.string.ZQ1A2));
        q1.setOption3(getString(R.string.ZQ1A3));
        q1.setOption4(getString(R.string.ZQ1A4));
        q1.setExplanation(getString(R.string.ZQ1E));

        questions.add(q1);

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestion(getString(R.string.ZQ2));
        q2.setOption1(getString(R.string.ZQ2A1));
        q2.setOption2(getString(R.string.ZQ2A2));
        q2.setOption3(getString(R.string.ZQ2A3));
        q2.setOption4(getString(R.string.ZQ2A4));
        q2.setExplanation(getString(R.string.ZQ2E));

        questions.add(q2);

        Question q3 = new Question();
        q3.setId(3);
        q3.setQuestion(getString(R.string.ZQ3));
        q3.setOption1(getString(R.string.ZQ3A1));
        q3.setOption2(getString(R.string.ZQ3A2));
        q3.setOption3(getString(R.string.ZQ3A3));
        q3.setOption4(getString(R.string.ZQ3A4));
        q3.setExplanation(getString(R.string.ZQ3E));

        questions.add(q3);

        Question q4 = new Question();
        q4.setId(4);
        q4.setQuestion(getString(R.string.ZQ4));
        q4.setOption1(getString(R.string.ZQ4A1));
        q4.setOption2(getString(R.string.ZQ4A2));
        q4.setOption3(getString(R.string.ZQ4A3));
        q4.setOption4(getString(R.string.ZQ4A4));
        q4.setExplanation(getString(R.string.ZQ4E));

        questions.add(q4);

        Question q5 = new Question();
        q5.setId(5);
        q5.setQuestion(getString(R.string.ZQ5));
        q5.setOption1(getString(R.string.ZQ5A1));
        q5.setOption2(getString(R.string.ZQ5A2));
        q5.setOption3(getString(R.string.ZQ5A3));
        q5.setOption4(getString(R.string.ZQ5A4));
        q5.setExplanation(getString(R.string.ZQ5E));

        questions.add(q5);

        Question q6 = new Question();
        q6.setId(6);
        q6.setQuestion(getString(R.string.ZQ6));
        q6.setOption1(getString(R.string.ZQ6A1));
        q6.setOption2(getString(R.string.ZQ6A2));
        q6.setOption3(getString(R.string.ZQ6A3));
        q6.setOption4(getString(R.string.ZQ6A4));
        q6.setExplanation(getString(R.string.ZQ6E));

        questions.add(q6);

        Question q7 = new Question();
        q7.setId(7);
        q7.setQuestion(getString(R.string.ZQ7));
        q7.setOption1(getString(R.string.ZQ7A1));
        q7.setOption2(getString(R.string.ZQ7A2));
        q7.setOption3(getString(R.string.ZQ7A3));
        q7.setOption4(getString(R.string.ZQ7A4));
        q7.setExplanation(getString(R.string.ZQ7E));

        questions.add(q7);

        Question q8 = new Question();
        q8.setId(8);
        q8.setQuestion(getString(R.string.ZQ8));
        q8.setOption1(getString(R.string.ZQ8A1));
        q8.setOption2(getString(R.string.ZQ8A2));
        q8.setOption3(getString(R.string.ZQ8A3));
        q8.setOption4(getString(R.string.ZQ8A4));
        q8.setExplanation(getString(R.string.ZQ8E));

        questions.add(q8);

        return questions;
    }

    private ArrayList<Question> setToniecie()
    {
        ArrayList<Question> questions = new ArrayList<>();

        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestion(getString(R.string.TQ1));
        q1.setOption1(getString(R.string.TQ1A1));
        q1.setOption2(getString(R.string.TQ1A2));
        q1.setOption3(getString(R.string.TQ1A3));
        q1.setOption4(getString(R.string.TQ1A4));
        q1.setExplanation(getString(R.string.TQ1E));

        questions.add(q1);

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestion(getString(R.string.TQ2));
        q2.setOption1(getString(R.string.TQ2A1));
        q2.setOption2(getString(R.string.TQ2A2));
        q2.setOption3(getString(R.string.TQ2A3));
        q2.setOption4(getString(R.string.TQ2A4));
        q2.setExplanation(getString(R.string.TQ2E));

        questions.add(q2);

        Question q3 = new Question();
        q3.setId(3);
        q3.setQuestion(getString(R.string.TQ3));
        q3.setOption1(getString(R.string.TQ3A1));
        q3.setOption2(getString(R.string.TQ3A2));
        q3.setOption3(getString(R.string.TQ3A3));
        q3.setOption4(getString(R.string.TQ3A4));
        q3.setExplanation(getString(R.string.TQ3E));

        questions.add(q3);

        Question q4 = new Question();
        q4.setId(4);
        q4.setQuestion(getString(R.string.TQ4));
        q4.setOption1(getString(R.string.TQ4A1));
        q4.setOption2(getString(R.string.TQ4A2));
        q4.setOption3(getString(R.string.TQ4A3));
        q4.setOption4(getString(R.string.TQ4A4));
        q4.setExplanation(getString(R.string.TQ4E));

        questions.add(q4);

        Question q5 = new Question();
        q5.setId(5);
        q5.setQuestion(getString(R.string.TQ5));
        q5.setOption1(getString(R.string.TQ5A1));
        q5.setOption2(getString(R.string.TQ5A2));
        q5.setOption3(getString(R.string.TQ5A3));
        q5.setOption4(getString(R.string.TQ5A4));
        q5.setExplanation(getString(R.string.TQ5E));

        questions.add(q5);

        Question q6 = new Question();
        q6.setId(6);
        q6.setQuestion(getString(R.string.TQ6));
        q6.setOption1(getString(R.string.TQ6A1));
        q6.setOption2(getString(R.string.TQ6A2));
        q6.setOption3(getString(R.string.TQ6A3));
        q6.setOption4(getString(R.string.TQ6A4));
        q6.setExplanation(getString(R.string.TQ6E));

        questions.add(q6);

        Question q7 = new Question();
        q7.setId(7);
        q7.setQuestion(getString(R.string.TQ7));
        q7.setOption1(getString(R.string.TQ7A1));
        q7.setOption2(getString(R.string.TQ7A2));
        q7.setOption3(getString(R.string.TQ7A3));
        q7.setOption4(getString(R.string.TQ7A4));
        q7.setExplanation(getString(R.string.TQ7E));

        questions.add(q7);

        Question q8 = new Question();
        q8.setId(8);
        q8.setQuestion(getString(R.string.TQ8));
        q8.setOption1(getString(R.string.TQ8A1));
        q8.setOption2(getString(R.string.TQ8A2));
        q8.setOption3(getString(R.string.TQ8A3));
        q8.setOption4(getString(R.string.TQ8A4));
        q8.setExplanation(getString(R.string.TQ8E));

        questions.add(q8);

        return questions;
    }

    private ArrayList<Question> setPorazenie()
    {
        ArrayList<Question> questions = new ArrayList<>();

        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestion(getString(R.string.PQ1));
        q1.setOption1(getString(R.string.PQ1A1));
        q1.setOption2(getString(R.string.PQ1A2));
        q1.setOption3(getString(R.string.PQ1A3));
        q1.setOption4(getString(R.string.PQ1A4));
        q1.setExplanation(getString(R.string.PQ1E));

        questions.add(q1);

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestion(getString(R.string.PQ2));
        q2.setOption1(getString(R.string.PQ2A1));
        q2.setOption2(getString(R.string.PQ2A2));
        q2.setOption3(getString(R.string.PQ2A3));
        q2.setOption4(getString(R.string.PQ2A4));
        q2.setExplanation(getString(R.string.PQ2E));

        questions.add(q2);

        Question q3 = new Question();
        q3.setId(3);
        q3.setQuestion(getString(R.string.PQ3));
        q3.setOption1(getString(R.string.PQ3A1));
        q3.setOption2(getString(R.string.PQ3A2));
        q3.setOption3(getString(R.string.PQ3A3));
        q3.setOption4(getString(R.string.PQ3A4));
        q3.setExplanation(getString(R.string.PQ3E));

        questions.add(q3);

        Question q4 = new Question();
        q4.setId(4);
        q4.setQuestion(getString(R.string.PQ4));
        q4.setOption1(getString(R.string.PQ4A1));
        q4.setOption2(getString(R.string.PQ4A2));
        q4.setOption3(getString(R.string.PQ4A3));
        q4.setOption4(getString(R.string.PQ4A4));
        q4.setExplanation(getString(R.string.PQ4E));

        questions.add(q4);

        Question q5 = new Question();
        q5.setId(5);
        q5.setQuestion(getString(R.string.PQ5));
        q5.setOption1(getString(R.string.PQ5A1));
        q5.setOption2(getString(R.string.PQ5A2));
        q5.setOption3(getString(R.string.PQ5A3));
        q5.setOption4(getString(R.string.PQ5A4));
        q5.setExplanation(getString(R.string.PQ5E));

        questions.add(q5);

        Question q6 = new Question();
        q6.setId(6);
        q6.setQuestion(getString(R.string.PQ6));
        q6.setOption1(getString(R.string.PQ6A1));
        q6.setOption2(getString(R.string.PQ6A2));
        q6.setOption3(getString(R.string.PQ6A3));
        q6.setOption4(getString(R.string.PQ6A4));
        q6.setExplanation(getString(R.string.PQ6E));

        questions.add(q6);

        Question q7 = new Question();
        q7.setId(7);
        q7.setQuestion(getString(R.string.PQ7));
        q7.setOption1(getString(R.string.PQ7A1));
        q7.setOption2(getString(R.string.PQ7A2));
        q7.setOption3(getString(R.string.PQ7A3));
        q7.setOption4(getString(R.string.PQ7A4));
        q7.setExplanation(getString(R.string.PQ7E));

        questions.add(q7);

        Question q8 = new Question();
        q8.setId(8);
        q8.setQuestion(getString(R.string.PQ8));
        q8.setOption1(getString(R.string.PQ8A1));
        q8.setOption2(getString(R.string.PQ8A2));
        q8.setOption3(getString(R.string.PQ8A3));
        q8.setOption4(getString(R.string.PQ8A4));
        q8.setExplanation(getString(R.string.PQ8E));

        questions.add(q8);

        return questions;
    }

    private ArrayList<Question> setOparzenie()
    {
        ArrayList<Question> questions = new ArrayList<>();

        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestion(getString(R.string.OQ1));
        q1.setOption1(getString(R.string.OQ1A1));
        q1.setOption2(getString(R.string.OQ1A2));
        q1.setOption3(getString(R.string.OQ1A3));
        q1.setOption4(getString(R.string.OQ1A4));
        q1.setExplanation(getString(R.string.OQ1E));

        questions.add(q1);

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestion(getString(R.string.OQ2));
        q2.setOption1(getString(R.string.OQ2A1));
        q2.setOption2(getString(R.string.OQ2A2));
        q2.setOption3(getString(R.string.OQ2A3));
        q2.setOption4(getString(R.string.OQ2A4));
        q2.setExplanation(getString(R.string.OQ2E));

        questions.add(q2);

        Question q3 = new Question();
        q3.setId(3);
        q3.setQuestion(getString(R.string.OQ3));
        q3.setOption1(getString(R.string.OQ3A1));
        q3.setOption2(getString(R.string.OQ3A2));
        q3.setOption3(getString(R.string.OQ3A3));
        q3.setOption4(getString(R.string.OQ3A4));
        q3.setExplanation(getString(R.string.OQ3E));

        questions.add(q3);

        Question q4 = new Question();
        q4.setId(4);
        q4.setQuestion(getString(R.string.OQ4));
        q4.setOption1(getString(R.string.OQ4A1));
        q4.setOption2(getString(R.string.OQ4A2));
        q4.setOption3(getString(R.string.OQ4A3));
        q4.setOption4(getString(R.string.OQ4A4));
        q4.setExplanation(getString(R.string.OQ4E));

        questions.add(q4);

        Question q5 = new Question();
        q5.setId(5);
        q5.setQuestion(getString(R.string.OQ5));
        q5.setOption1(getString(R.string.OQ5A1));
        q5.setOption2(getString(R.string.OQ5A2));
        q5.setOption3(getString(R.string.OQ5A3));
        q5.setOption4(getString(R.string.OQ5A4));
        q5.setExplanation(getString(R.string.OQ5E));

        questions.add(q5);

        Question q6 = new Question();
        q6.setId(6);
        q6.setQuestion(getString(R.string.OQ6));
        q6.setOption1(getString(R.string.OQ6A1));
        q6.setOption2(getString(R.string.OQ6A2));
        q6.setOption3(getString(R.string.OQ6A3));
        q6.setOption4(getString(R.string.OQ6A4));
        q6.setExplanation(getString(R.string.OQ6E));

        questions.add(q6);

        Question q7 = new Question();
        q7.setId(7);
        q7.setQuestion(getString(R.string.OQ7));
        q7.setOption1(getString(R.string.OQ7A1));
        q7.setOption2(getString(R.string.OQ7A2));
        q7.setOption3(getString(R.string.OQ7A3));
        q7.setOption4(getString(R.string.OQ7A4));
        q7.setExplanation(getString(R.string.OQ7E));

        questions.add(q7);

        Question q8 = new Question();
        q8.setId(8);
        q8.setQuestion(getString(R.string.OQ8));
        q8.setOption1(getString(R.string.OQ8A1));
        q8.setOption2(getString(R.string.OQ8A2));
        q8.setOption3(getString(R.string.OQ8A3));
        q8.setOption4(getString(R.string.OQ8A4));
        q8.setExplanation(getString(R.string.OQ8E));

        questions.add(q8);

        return questions;
    }

    private ArrayList<Question> setRany()
    {
        ArrayList<Question> questions = new ArrayList<>();

        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestion(getString(R.string.RQ1));
        q1.setOption1(getString(R.string.RQ1A1));
        q1.setOption2(getString(R.string.RQ1A2));
        q1.setOption3(getString(R.string.RQ1A3));
        q1.setOption4(getString(R.string.RQ1A4));
        q1.setExplanation(getString(R.string.RQ1E));

        questions.add(q1);

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestion(getString(R.string.RQ2));
        q2.setOption1(getString(R.string.RQ2A1));
        q2.setOption2(getString(R.string.RQ2A2));
        q2.setOption3(getString(R.string.RQ2A3));
        q2.setOption4(getString(R.string.RQ2A4));
        q2.setExplanation(getString(R.string.RQ2E));

        questions.add(q2);

        Question q3 = new Question();
        q3.setId(3);
        q3.setQuestion(getString(R.string.RQ3));
        q3.setOption1(getString(R.string.RQ3A1));
        q3.setOption2(getString(R.string.RQ3A2));
        q3.setOption3(getString(R.string.RQ3A3));
        q3.setOption4(getString(R.string.RQ3A4));
        q3.setExplanation(getString(R.string.RQ3E));

        questions.add(q3);

        Question q4 = new Question();
        q4.setId(4);
        q4.setQuestion(getString(R.string.RQ4));
        q4.setOption1(getString(R.string.RQ4A1));
        q4.setOption2(getString(R.string.RQ4A2));
        q4.setOption3(getString(R.string.RQ4A3));
        q4.setOption4(getString(R.string.RQ4A4));
        q4.setExplanation(getString(R.string.RQ4E));

        questions.add(q4);

        Question q5 = new Question();
        q5.setId(5);
        q5.setQuestion(getString(R.string.RQ5));
        q5.setOption1(getString(R.string.RQ5A1));
        q5.setOption2(getString(R.string.RQ5A2));
        q5.setOption3(getString(R.string.RQ5A3));
        q5.setOption4(getString(R.string.RQ5A4));
        q5.setExplanation(getString(R.string.RQ5E));

        questions.add(q5);

        Question q6 = new Question();
        q6.setId(6);
        q6.setQuestion(getString(R.string.RQ6));
        q6.setOption1(getString(R.string.RQ6A1));
        q6.setOption2(getString(R.string.RQ6A2));
        q6.setOption3(getString(R.string.RQ6A3));
        q6.setOption4(getString(R.string.RQ6A4));
        q6.setExplanation(getString(R.string.RQ6E));

        questions.add(q6);

        Question q7 = new Question();
        q7.setId(7);
        q7.setQuestion(getString(R.string.RQ7));
        q7.setOption1(getString(R.string.RQ7A1));
        q7.setOption2(getString(R.string.RQ7A2));
        q7.setOption3(getString(R.string.RQ7A3));
        q7.setOption4(getString(R.string.RQ7A4));
        q7.setExplanation(getString(R.string.RQ7E));

        questions.add(q7);

        Question q8 = new Question();
        q8.setId(8);
        q8.setQuestion(getString(R.string.RQ8));
        q8.setOption1(getString(R.string.RQ8A1));
        q8.setOption2(getString(R.string.RQ8A2));
        q8.setOption3(getString(R.string.RQ8A3));
        q8.setOption4(getString(R.string.RQ8A4));
        q8.setExplanation(getString(R.string.RQ8E));

        questions.add(q8);

        return questions;
    }

    private ArrayList<Question> setRKO()
    {
        ArrayList<Question> questions = new ArrayList<>();

        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestion(getString(R.string.RKOQ1));
        q1.setOption1(getString(R.string.RKOQ1A1));
        q1.setOption2(getString(R.string.RKOQ1A2));
        q1.setOption3(getString(R.string.RKOQ1A3));
        q1.setOption4(getString(R.string.RKOQ1A4));
        q1.setExplanation(getString(R.string.RKOQ1E));

        questions.add(q1);

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestion(getString(R.string.RKOQ2));
        q2.setOption1(getString(R.string.RKOQ2A1));
        q2.setOption2(getString(R.string.RKOQ2A2));
        q2.setOption3(getString(R.string.RKOQ2A3));
        q2.setOption4(getString(R.string.RKOQ2A4));
        q2.setExplanation(getString(R.string.RKOQ2E));

        questions.add(q2);

        Question q3 = new Question();
        q3.setId(3);
        q3.setQuestion(getString(R.string.RKOQ3));
        q3.setOption1(getString(R.string.RKOQ3A1));
        q3.setOption2(getString(R.string.RKOQ3A2));
        q3.setOption3(getString(R.string.RKOQ3A3));
        q3.setOption4(getString(R.string.RKOQ3A4));
        q3.setExplanation(getString(R.string.RKOQ3E));

        questions.add(q3);

        Question q4 = new Question();
        q4.setId(4);
        q4.setQuestion(getString(R.string.RKOQ4));
        q4.setOption1(getString(R.string.RKOQ4A1));
        q4.setOption2(getString(R.string.RKOQ4A2));
        q4.setOption3(getString(R.string.RKOQ4A3));
        q4.setOption4(getString(R.string.RKOQ4A4));
        q4.setExplanation(getString(R.string.RKOQ4E));

        questions.add(q4);

        Question q5 = new Question();
        q5.setId(5);
        q5.setQuestion(getString(R.string.RKOQ5));
        q5.setOption1(getString(R.string.RKOQ5A1));
        q5.setOption2(getString(R.string.RKOQ5A2));
        q5.setOption3(getString(R.string.RKOQ5A3));
        q5.setOption4(getString(R.string.RKOQ5A4));
        q5.setExplanation(getString(R.string.RKOQ5E));

        questions.add(q5);

        Question q6 = new Question();
        q6.setId(6);
        q6.setQuestion(getString(R.string.RKOQ6));
        q6.setOption1(getString(R.string.RKOQ6A1));
        q6.setOption2(getString(R.string.RKOQ6A2));
        q6.setOption3(getString(R.string.RKOQ6A3));
        q6.setOption4(getString(R.string.RKOQ6A4));
        q6.setExplanation(getString(R.string.RKOQ6E));

        questions.add(q6);

        Question q7 = new Question();
        q7.setId(7);
        q7.setQuestion(getString(R.string.RKOQ7));
        q7.setOption1(getString(R.string.RKOQ7A1));
        q7.setOption2(getString(R.string.RKOQ7A2));
        q7.setOption3(getString(R.string.RKOQ7A3));
        q7.setOption4(getString(R.string.RKOQ7A4));
        q7.setExplanation(getString(R.string.RKOQ7E));

        questions.add(q7);

        Question q8 = new Question();
        q8.setId(8);
        q8.setQuestion(getString(R.string.RKOQ8));
        q8.setOption1(getString(R.string.RKOQ8A1));
        q8.setOption2(getString(R.string.RKOQ8A2));
        q8.setOption3(getString(R.string.RKOQ8A3));
        q8.setOption4(getString(R.string.RKOQ8A4));
        q8.setExplanation(getString(R.string.RKOQ8E));

        questions.add(q8);

        return questions;
    }

    private ArrayList<Question> setPrzytmnosc()
    {
        ArrayList<Question> questions = new ArrayList<>();

        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestion(getString(R.string.UPQ1));
        q1.setOption1(getString(R.string.UPQ1A1));
        q1.setOption2(getString(R.string.UPQ1A2));
        q1.setOption3(getString(R.string.UPQ1A3));
        q1.setOption4(getString(R.string.UPQ1A4));
        q1.setExplanation(getString(R.string.UPQ1E));

        questions.add(q1);

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestion(getString(R.string.UPQ2));
        q2.setOption1(getString(R.string.UPQ2A1));
        q2.setOption2(getString(R.string.UPQ2A2));
        q2.setOption3(getString(R.string.UPQ2A3));
        q2.setOption4(getString(R.string.UPQ2A4));
        q2.setExplanation(getString(R.string.UPQ2E));

        questions.add(q2);

        Question q3 = new Question();
        q3.setId(3);
        q3.setQuestion(getString(R.string.UPQ3));
        q3.setOption1(getString(R.string.UPQ3A1));
        q3.setOption2(getString(R.string.UPQ3A2));
        q3.setOption3(getString(R.string.UPQ3A3));
        q3.setOption4(getString(R.string.UPQ3A4));
        q3.setExplanation(getString(R.string.UPQ3E));

        questions.add(q3);

        Question q4 = new Question();
        q4.setId(4);
        q4.setQuestion(getString(R.string.UPQ4));
        q4.setOption1(getString(R.string.UPQ4A1));
        q4.setOption2(getString(R.string.UPQ4A2));
        q4.setOption3(getString(R.string.UPQ4A3));
        q4.setOption4(getString(R.string.UPQ4A4));
        q4.setExplanation(getString(R.string.UPQ4E));

        questions.add(q4);

        Question q5 = new Question();
        q5.setId(5);
        q5.setQuestion(getString(R.string.UPQ5));
        q5.setOption1(getString(R.string.UPQ5A1));
        q5.setOption2(getString(R.string.UPQ5A2));
        q5.setOption3(getString(R.string.UPQ5A3));
        q5.setOption4(getString(R.string.UPQ5A4));
        q5.setExplanation(getString(R.string.UPQ5E));

        questions.add(q5);

        Question q6 = new Question();
        q6.setId(6);
        q6.setQuestion(getString(R.string.UPQ6));
        q6.setOption1(getString(R.string.UPQ6A1));
        q6.setOption2(getString(R.string.UPQ6A2));
        q6.setOption3(getString(R.string.UPQ6A3));
        q6.setOption4(getString(R.string.UPQ6A4));
        q6.setExplanation(getString(R.string.UPQ6E));

        questions.add(q6);

        Question q7 = new Question();
        q7.setId(7);
        q7.setQuestion(getString(R.string.UPQ7));
        q7.setOption1(getString(R.string.UPQ7A1));
        q7.setOption2(getString(R.string.UPQ7A2));
        q7.setOption3(getString(R.string.UPQ7A3));
        q7.setOption4(getString(R.string.UPQ7A4));
        q7.setExplanation(getString(R.string.UPQ7E));

        questions.add(q7);

        Question q8 = new Question();
        q8.setId(8);
        q8.setQuestion(getString(R.string.UPQ8));
        q8.setOption1(getString(R.string.UPQ8A1));
        q8.setOption2(getString(R.string.UPQ8A2));
        q8.setOption3(getString(R.string.UPQ8A3));
        q8.setOption4(getString(R.string.UPQ8A4));
        q8.setExplanation(getString(R.string.UPQ8E));

        questions.add(q8);

        return questions;
    }

    private ArrayList<Question> setZawal()
    {
        ArrayList<Question> questions = new ArrayList<>();

        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestion(getString(R.string.ZAWQ1));
        q1.setOption1(getString(R.string.ZAWQ1A1));
        q1.setOption2(getString(R.string.ZAWQ1A2));
        q1.setOption3(getString(R.string.ZAWQ1A3));
        q1.setOption4(getString(R.string.ZAWQ1A4));
        q1.setExplanation(getString(R.string.ZAWQ1E));

        questions.add(q1);

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestion(getString(R.string.ZAWQ2));
        q2.setOption1(getString(R.string.ZAWQ2A1));
        q2.setOption2(getString(R.string.ZAWQ2A2));
        q2.setOption3(getString(R.string.ZAWQ2A3));
        q2.setOption4(getString(R.string.ZAWQ2A4));
        q2.setExplanation(getString(R.string.ZAWQ2E));

        questions.add(q2);

        Question q3 = new Question();
        q3.setId(3);
        q3.setQuestion(getString(R.string.ZAWQ3));
        q3.setOption1(getString(R.string.ZAWQ3A1));
        q3.setOption2(getString(R.string.ZAWQ3A2));
        q3.setOption3(getString(R.string.ZAWQ3A3));
        q3.setOption4(getString(R.string.ZAWQ3A4));
        q3.setExplanation(getString(R.string.ZAWQ3E));

        questions.add(q3);

        Question q4 = new Question();
        q4.setId(4);
        q4.setQuestion(getString(R.string.ZAWQ4));
        q4.setOption1(getString(R.string.ZAWQ4A1));
        q4.setOption2(getString(R.string.ZAWQ4A2));
        q4.setOption3(getString(R.string.ZAWQ4A3));
        q4.setOption4(getString(R.string.ZAWQ4A4));
        q4.setExplanation(getString(R.string.ZAWQ4E));

        questions.add(q4);

        Question q5 = new Question();
        q5.setId(5);
        q5.setQuestion(getString(R.string.ZAWQ5));
        q5.setOption1(getString(R.string.ZAWQ5A1));
        q5.setOption2(getString(R.string.ZAWQ5A2));
        q5.setOption3(getString(R.string.ZAWQ5A3));
        q5.setOption4(getString(R.string.ZAWQ5A4));
        q5.setExplanation(getString(R.string.ZAWQ5E));

        questions.add(q5);

        Question q6 = new Question();
        q6.setId(6);
        q6.setQuestion(getString(R.string.ZAWQ6));
        q6.setOption1(getString(R.string.ZAWQ6A1));
        q6.setOption2(getString(R.string.ZAWQ6A2));
        q6.setOption3(getString(R.string.ZAWQ6A3));
        q6.setOption4(getString(R.string.ZAWQ6A4));
        q6.setExplanation(getString(R.string.ZAWQ6E));

        questions.add(q6);

        Question q7 = new Question();
        q7.setId(7);
        q7.setQuestion(getString(R.string.ZAWQ7));
        q7.setOption1(getString(R.string.ZAWQ7A1));
        q7.setOption2(getString(R.string.ZAWQ7A2));
        q7.setOption3(getString(R.string.ZAWQ7A3));
        q7.setOption4(getString(R.string.ZAWQ7A4));
        q7.setExplanation(getString(R.string.ZAWQ7E));

        questions.add(q7);

        Question q8 = new Question();
        q8.setId(8);
        q8.setQuestion(getString(R.string.ZAWQ8));
        q8.setOption1(getString(R.string.ZAWQ8A1));
        q8.setOption2(getString(R.string.ZAWQ8A2));
        q8.setOption3(getString(R.string.ZAWQ8A3));
        q8.setOption4(getString(R.string.ZAWQ8A4));
        q8.setExplanation(getString(R.string.ZAWQ8E));

        questions.add(q8);

        return questions;
    }
}

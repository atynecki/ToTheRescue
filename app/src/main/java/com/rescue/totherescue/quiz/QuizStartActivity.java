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

        //Set case name
        TextView case_name = (TextView) findViewById(R.id.textView_case);
        case_name.setText(thisCase);

        //Set discription
        TextView description = (TextView) findViewById(R.id.textView_description);
        description.setText(getQuizDescription(12));

        start_button = (Button) findViewById(R.id.button_start);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizStartActivity.this, QuestionActivity.class);
                intent.putExtra("quiz", quiz);
                startActivity(intent);
            }
        });
    }

    private String getQuizDescription(int question_num)
    {
        return "You have to quiz with "+String.valueOf(question_num)+"question. To answer youe have 30 second for every one.";
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}

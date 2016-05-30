package com.rescue.totherescue.quiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rescue.totherescue.CaseActivity;
import com.rescue.totherescue.R;
import com.rescue.totherescue.quiz.model.Quiz;

public class QuestionActivity extends AppCompatActivity {

    private Quiz quiz;
    private Button finish_button;
    private TextView question;
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    private TextView timer_view;
    private TextView question_counter;

    private int current_question;
    private int correct_answer_num;

    private final TimeCounter timer = new TimeCounter(30000,100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        quiz = (Quiz)intent.getSerializableExtra("quiz");

        finish_button = (Button) findViewById(R.id.button_finish);
        question = (TextView) findViewById(R.id.textView_question);
        option1 = (Button) findViewById(R.id.button_option1);
        option2 = (Button) findViewById(R.id.button_option2);
        option3 = (Button) findViewById(R.id.button_option3);
        option4 = (Button) findViewById(R.id.button_option4);

        current_question = 0;

        timer_view = (TextView) findViewById(R.id.textView_timer);
        question_counter = (TextView) findViewById(R.id.textView_question_num);

        finish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult();
            }
        });

        setNextQuestion();
    }

    private void setResult ()
    {
        Intent intent = new Intent( QuestionActivity.this, ResultActivity.class);
        quiz.setCorrect_answer(4);
        quiz.setWrong_answer(4);
        intent.putExtra("correct", quiz.getCorrect_answer());
        intent.putExtra("wrong", quiz.getWrong_answer());
        startActivity(intent);
    }

    private void updateQuestionCounter ()
    {
        question_counter.setText(String.valueOf(current_question)+"/"+String.valueOf(quiz.getQuestion_number()));
    }

    private void setNextQuestion ()
    {
        current_question++;

        updateQuestionCounter();
        timer.start();
    }

    public class TimeCounter extends CountDownTimer {

        public TimeCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            if(current_question < quiz.getQuestion_number())
            {
                setNextQuestion();
            }

            else
            {
                setResult();
            }
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if(millisUntilFinished/1000 > 9)
                timer_view.setText("0:"+String.valueOf(millisUntilFinished/1000));
            else
                timer_view.setText("0:0"+String.valueOf(millisUntilFinished/1000));
        }
    }
}

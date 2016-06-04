package com.rescue.totherescue.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rescue.totherescue.R;
import com.rescue.totherescue.quiz.model.Question;
import com.rescue.totherescue.quiz.model.Quiz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuestionActivity extends AppCompatActivity implements DialogInterface.OnDismissListener {

    private Quiz quiz;
    private Button finish_button;
    private TextView question;
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    private TextView timer_view;
    private TextView question_counter;

    private int current_question_num;
    private Question current_question;
    private String current_answer;

    private final TimeCounter timer = new TimeCounter(45000,100);

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

        current_question_num = 0;
        current_question = new Question();

        timer_view = (TextView) findViewById(R.id.textView_timer);
        question_counter = (TextView) findViewById(R.id.textView_question_num);

        finish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult();
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer((String) option1.getText());
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer((String)option2.getText());
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer((String)option3.getText());
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswer((String)option4.getText());
            }
        });

        setNextQuestion();
    }

    private void setResult ()
    {
        Intent intent = new Intent( QuestionActivity.this, ResultActivity.class);
        intent.putExtra("correct", quiz.getCorrect_answer());
        intent.putExtra("wrong", quiz.getWrong_answer());
        startActivity(intent);
        finish();
    }

    private void updateQuestionCounter ()
    {
        question_counter.setText(String.valueOf(current_question_num) + "/" + String.valueOf(quiz.getQuestion_number()));
    }

    private void setNextQuestion ()
    {
        if(current_question_num >= quiz.getQuestion_number())
        {
            setResult();
        }
        else
        {
            current_question = quiz.getQuestions().get(current_question_num++);

            question.setText(current_question.getQuestion());
            current_answer = current_question.getOption1();

            String[] q_shuffle = {current_question.getOption1(), current_question.getOption2(), current_question.getOption3(), current_question.getOption4()};
            Collections.shuffle(Arrays.asList(q_shuffle));

            option1.setText(q_shuffle[0]);
            option2.setText(q_shuffle[1]);
            option3.setText(q_shuffle[2]);
            option4.setText(q_shuffle[3]);

            updateQuestionCounter();
            timer.start();
        }
    }

    void showDialogFragment(String text)
    {
        FragmentManager fm = getSupportFragmentManager();
        DialogFragment newFragment = ExplanationFragment.getInstance(text);
        newFragment.show(fm, null);
    }

    private void verifyAnswer (String answer)
    {
        if(current_answer.equals(answer))
        {
            quiz.setCorrectAnswer();
            setNextQuestion();
        }
        else
        {
            timer.cancel();
            showDialogFragment(current_question.getExplanation());
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog)
    {
        setNextQuestion();
    }

    public class TimeCounter extends CountDownTimer {

        public TimeCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            if(current_question_num < quiz.getQuestion_number())
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

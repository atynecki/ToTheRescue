package com.rescue.totherescue.help.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rescue.totherescue.R;

public class HelpSimpleQuestionActivity extends AppCompatActivity {

    private static String question;
    private static String answer1;
    private static String answer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_simple_question);

        Intent intent = getIntent();
        question = intent.getStringExtra("question");
        answer1 = intent.getStringExtra("answer1");
        answer2 = intent.getStringExtra("answer2");

        TextView question_view = (TextView) findViewById(R.id.textView_question);
        question_view.setText(question);

        Button answer1_button = (Button) findViewById(R.id.button_answer1);
        answer1_button.setText(answer1);
        answer1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("answer", 1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button answer2_button = (Button) findViewById(R.id.button_answer2);
        answer2_button.setText(answer2);
        answer2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("answer", 2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

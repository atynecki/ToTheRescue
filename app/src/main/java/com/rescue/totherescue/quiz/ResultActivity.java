package com.rescue.totherescue.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.rescue.totherescue.R;
import com.rescue.totherescue.quiz.model.Quiz;

public class ResultActivity extends AppCompatActivity {

    private ImageView result_image;
    private TextView correct_answer;
    private TextView wrong_answer;

    private int drawableImageID;

    private int low_ths = 25;
    private int high_ths = 75;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result_image = (ImageView) findViewById(R.id.imageView_result);
        correct_answer = (TextView) findViewById(R.id.textView_ca_result);
        wrong_answer = (TextView) findViewById(R.id.textView_wa_result);

        Intent intent = getIntent();
        int wrong_result = intent.getIntExtra("wrong", 1);
        int correct_result = intent.getIntExtra("correct", 1);

        correct_answer.setText(String.valueOf(correct_result));
        wrong_answer.setText(String.valueOf(wrong_result));

        setQuizResult (wrong_result, correct_result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_menu_info) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setQuizResult (int wrong, int correct)
    {
        int correct_precent = (int)(((double)(correct) / (double)(correct+wrong))*100);

        if(correct_precent >= high_ths)
        {
            drawableImageID = R.drawable.good;
            result_image.setImageDrawable(getResources().getDrawable(drawableImageID));
        }
        else if(correct_precent <= low_ths)
        {
            drawableImageID = R.drawable.bad;
            result_image.setImageDrawable(getResources().getDrawable(drawableImageID));
        }
        else
        {
            drawableImageID = R.drawable.medium;
            result_image.setImageDrawable(getResources().getDrawable(drawableImageID));
        }

    }
}

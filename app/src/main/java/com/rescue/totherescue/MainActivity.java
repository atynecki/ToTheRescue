package com.rescue.totherescue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.rescue.totherescue.database.QuizDatabaseHelper;
import com.rescue.totherescue.quiz.model.Question;

public class MainActivity extends AppCompatActivity {

    public static final String quiz_mode = "QUIZ";
    public static final String help_mode = "HELP";

    QuizDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button help =  (Button) findViewById(R.id.button_help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaseActivity.class);
                intent.putExtra("mode", help_mode);
                startActivity(intent);
            }
        });

        Button quiz =  (Button) findViewById(R.id.button_quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaseActivity.class);
                intent.putExtra("mode", quiz_mode);
                startActivity(intent);
            }
        });

        createQuizDatabse();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_menu_info) {
            Intent intent = new Intent(this, AppInfoActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void createQuizDatabse ()
    {
        db = new QuizDatabaseHelper(getApplicationContext());
    }
}

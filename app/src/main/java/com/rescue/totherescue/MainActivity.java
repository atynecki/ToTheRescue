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
            //Intent intent = new Intent(this, InfoActivity.class);
            //startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void createQuizDatabse ()
    {
        db = new QuizDatabaseHelper(getApplicationContext());

        //Zadławienie questions create
        Question zadlawienie1 = new Question();
        zadlawienie1.setQuestion("Dorosła osoba po zadławieniu straciła przytomność. Co robisz?");
        zadlawienie1.setOption1("Wzywam pomoc i przechodzę do resuscytacji – 30 uciśnięć : 2 wdechy");
        zadlawienie1.setOption2("Naprzemiennie wykonuję 5 uciśnięć w okolicę międzyłopatkową i  5 uciśnięć nadbrzusza");
        zadlawienie1.setOption3("Wykonuję na przemian 2 wdechy ratownicze i 5 uciśnięć nadbrzusza");
        zadlawienie1.setOption4("Wzywam pomoc i przechodzę do resuscytacji –  15 uciśnięć : 2 wdechy");
        zadlawienie1.setExplanation("Przy zadławieniu osoby dorosłej, nasze postępowanie zależy od jej stanu. \n" +
                "\n" +
                "Jeżeli kaszle, a jej kaszel jest efektywny - zachęcamy do dalszego kaszlu i monitorujemy jej stan, by móc zareagować na ewentualne pogorszenie.\n" +
                "\n" +
                "Jeżeli nie kaszle, lub kaszel jest nieefektywny a osoba jest przytomna, wykonujemy naprzemiennie 5 uciśnięć w okolicę międzyłopatkową i  5 uciśnięć nadbrzusza.\n" +
                "\n" +
                "Jeżeli osoba straciła przytomność, przechodzimy do resuscytacji krążeniowo-oddechowej (30 uciśnięć : 2 wdechy)\n");
        db.addQuestion(getString(R.string.zadlawienie), zadlawienie1);
    }
}

package com.rescue.totherescue;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);

        Button quiz_button = (Button) findViewById(R.id.button_quiz);
        quiz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQuizDialogFragment();
            }
        });

        Button help_button = (Button) findViewById(R.id.button_help);
        help_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHelpDialogFragment();
            }
        });
    }

    void showQuizDialogFragment()
    {
        FragmentManager fm = getSupportFragmentManager();
        DialogFragment newFragment = QuizInfoFragment.getInstance();
        newFragment.show(fm, null);
    }

    void showHelpDialogFragment()
    {
        FragmentManager fm = getSupportFragmentManager();
        DialogFragment newFragment = HelpInfoFragment.getInstance();
        newFragment.show(fm, null);
    }
}

package com.rescue.totherescue;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.ArrayList;

public class CaseActivity extends AppCompatActivity {

    private String mode;
    private RecyclerView recyclerView;
    private CaseAdapter caseAdapter;

    private static final String quiz_mode = "QUIZ";
    private  static final String help_mode = "HELP";

    private ArrayList<String> caseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);

        Intent intent = getIntent();
        mode= intent.getStringExtra(getString(R.string.mode));

        TextView mode_text =  (TextView) findViewById(R.id.textView_mode);
        if(mode.equals(help_mode))
            mode_text.setText(R.string.help_name);
        else if(mode.equals(quiz_mode))
            mode_text.setText(R.string.quiz_name);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        caseList = new ArrayList<String>();
        caseList.add(getString(R.string.zadlawienie));
        caseList.add(getString(R.string.toniecie));
        caseList.add(getString(R.string.porazenie));
        caseList.add(getString(R.string.oparzenie));
        caseList.add(getString(R.string.rany));
        caseList.add(getString(R.string.rko));
        caseList.add(getString(R.string.przytomnosc));
        caseList.add(getString(R.string.zawal));

        caseAdapter = new CaseAdapter(caseList, mode);
        recyclerView.setAdapter(caseAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_case, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_menu_info) {
            showDialogFragment();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void showDialogFragment()
    {
        FragmentManager fm = getSupportFragmentManager();
        if(mode.equals(quiz_mode)) {
            DialogFragment newFragment = QuizInfoFragment.getInstance();
            newFragment.show(fm, null);
        }
        else if(mode.equals(help_mode))
        {
            DialogFragment newFragment = HelpInfoFragment.getInstance();
            newFragment.show(fm, null);
        }
    }
}

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

public class HelpStepWithInfoActivity extends AppCompatActivity {

    private static String step_brief;
    private static String step_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_step_with_info);

        Intent intent = getIntent();
        step_brief = intent.getStringExtra("step_brief");
        step_info = intent.getStringExtra("step_info");

        TextView brief_view = (TextView) findViewById(R.id.textView_step_brief);
        brief_view.setText(step_brief);

        TextView info_view = (TextView) findViewById(R.id.textView_step_info);
        info_view.setText(step_info);

        Button next = (Button) findViewById(R.id.button_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("next", true);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

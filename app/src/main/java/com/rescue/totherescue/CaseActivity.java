package com.rescue.totherescue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class CaseActivity extends AppCompatActivity {

    private String mode;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);

        Intent intent = getIntent();
        mode= intent.getStringExtra("mode");

        TextView mode_text =  (TextView) findViewById(R.id.textView_mode);
        mode_text.setText(mode);
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
            //Intent intent = new Intent(this, InfoActivity.class);
            //startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

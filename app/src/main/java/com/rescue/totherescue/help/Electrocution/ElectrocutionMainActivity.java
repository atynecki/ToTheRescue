package com.rescue.totherescue.help.Electrocution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.rescue.totherescue.AppInfoActivity;
import com.rescue.totherescue.CaseActivity;
import com.rescue.totherescue.R;
import com.rescue.totherescue.help.Views.HelpSimpleStepActivity;
import com.rescue.totherescue.help.Views.HelpStepWithInfoActivity;

public class ElectrocutionMainActivity extends AppCompatActivity {

    private int step_counter;
    private static final Integer REQUEST_NEXT = 0;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrocution_main);

        step_counter = 0;

        start = (Button) findViewById(R.id.button_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start.getText().equals(getString(R.string.start_text)))
                {
                    step_counter++;
                    Intent intent = new Intent(ElectrocutionMainActivity.this, HelpStepWithInfoActivity.class);
                    intent.putExtra("step_brief", getString(R.string.HP_S1B));
                    intent.putExtra("step_info", getString(R.string.HP_S1I));
                    startActivityForResult(intent, REQUEST_NEXT);
                }
                else if(start.getText().equals(getString(R.string.end_text)))
                {
                    finish();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_NEXT) {
            if(data == null)
                return;
            Boolean next = data.getBooleanExtra("next", false);
            if(next == true) {

                switch(step_counter)
                {
                    case 1:
                        Intent intent1 = new Intent(ElectrocutionMainActivity.this, HelpSimpleStepActivity.class);
                        intent1.putExtra("step_brief", getString(R.string.HP_S2B));
                        startActivityForResult(intent1, REQUEST_NEXT);
                        break;
                    case 2:
                        Intent intent2 = new Intent(ElectrocutionMainActivity.this, HelpSimpleStepActivity.class);
                        intent2.putExtra("step_brief", getString(R.string.HP_S3B));
                        startActivityForResult(intent2, REQUEST_NEXT);
                        break;
                    case 3:
                        Intent intent3 = new Intent(ElectrocutionMainActivity.this, HelpSimpleStepActivity.class);
                        intent3.putExtra("step_brief", getString(R.string.HP_S4B));
                        startActivityForResult(intent3, REQUEST_NEXT);
                        break;
                    case 4:
                        start.setText(R.string.end_text);
                        break;
                    default:
                        break;
                }
                step_counter++;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_electrocution_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_menu_info) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.rescue.totherescue.help.Unconsciousness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.rescue.totherescue.R;
import com.rescue.totherescue.help.Views.HelpSimpleQuestionActivity;
import com.rescue.totherescue.help.Views.HelpSimpleStepActivity;
import com.rescue.totherescue.help.Views.HelpStepWithInfoActivity;
import com.rescue.totherescue.help.Views.HelpStepWithPhotoActivity;

public class UnconsciousnessMainActivity extends AppCompatActivity {

    private int step_counter;
    private static final Integer REQUEST_NEXT = 0;
    private static final Integer REQUEST_DECISION = 1;
    private Button start;
    private Boolean injured;
    private Boolean conscious;
    private Boolean breath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unconsciousness_main);

        step_counter = 0;

        start = (Button) findViewById(R.id.button_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (start.getText().equals(getString(R.string.start_text))) {
                    step_counter++;
                    Intent intent = new Intent(UnconsciousnessMainActivity.this, HelpStepWithInfoActivity.class);
                    intent.putExtra("step_brief", getString(R.string.HUP_S1B));
                    intent.putExtra("step_info", getString(R.string.HUP_S1I));
                    startActivityForResult(intent, REQUEST_NEXT);
                } else if (start.getText().equals(getString(R.string.end_text))) {
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
                        Intent intent1 = new Intent(UnconsciousnessMainActivity.this, HelpSimpleQuestionActivity.class);
                        intent1.putExtra("question", getString(R.string.HUP_S2Q));
                        intent1.putExtra("answer1" , getString(R.string.HUP_S2A1));
                        intent1.putExtra("answer2" , getString(R.string.HUP_S2A2));
                        startActivityForResult(intent1, REQUEST_DECISION);
                        break;
                    case 3:
                        Intent intent2 = new Intent(UnconsciousnessMainActivity.this,  HelpStepWithInfoActivity.class);
                        intent2.putExtra("step_brief", getString(R.string.HUP_S4B));
                        intent2.putExtra("step_info", getString(R.string.HUP_S4I));
                        startActivityForResult(intent2, REQUEST_NEXT);
                        break;
                    case 4:
                        if(injured == false)
                        {
                            Intent intent3 = new Intent(UnconsciousnessMainActivity.this,  HelpStepWithInfoActivity.class);
                            intent3.putExtra("step_brief", getString(R.string.HUP_S5BNU));
                            intent3.putExtra("step_info", getString(R.string.HUP_S5INU));
                            startActivityForResult(intent3, REQUEST_NEXT);
                        }
                        else
                        {
                            Intent intent3 = new Intent(UnconsciousnessMainActivity.this,  HelpStepWithPhotoActivity.class);
                            intent3.putExtra("step_brief", getString(R.string.HUP_S5BU));
                            intent3.putExtra("image_resource", R.drawable.up_step5);
                            startActivityForResult(intent3, REQUEST_NEXT);
                        }
                        break;
                    case 5:
                        Intent intent4 = new Intent(UnconsciousnessMainActivity.this, HelpSimpleQuestionActivity.class);
                        intent4.putExtra("question", getString(R.string.HUP_S6Q));
                        intent4.putExtra("answer1" , getString(R.string.HUP_S6A1));
                        intent4.putExtra("answer2" , getString(R.string.HUP_S6A2));
                        startActivityForResult(intent4, REQUEST_DECISION);
                        break;
                    case 7:
                        if(conscious)
                        {
                            start.setText(R.string.end_text);
                        }
                        else
                        {
                            Intent intent5 = new Intent(UnconsciousnessMainActivity.this, HelpStepWithInfoActivity.class);
                            intent5.putExtra("step_brief", getString(R.string.HUP_S8B));
                            intent5.putExtra("step_info", getString(R.string.HUP_S8I));
                            startActivityForResult(intent5, REQUEST_NEXT);
                        }
                        break;
                    case 8:
                        Intent intent6 = new Intent(UnconsciousnessMainActivity.this, HelpStepWithInfoActivity.class);
                        intent6.putExtra("step_brief", getString(R.string.HUP_S9B));
                        intent6.putExtra("step_info", getString(R.string.HUP_S9I));
                        startActivityForResult(intent6, REQUEST_NEXT);
                        break;
                    case 9:
                        Intent intent7 = new Intent(UnconsciousnessMainActivity.this, HelpSimpleQuestionActivity.class);
                        intent7.putExtra("question", getString(R.string.HUP_S10Q));
                        intent7.putExtra("answer1" , getString(R.string.HUP_S6A1));
                        intent7.putExtra("answer2" , getString(R.string.HUP_S6A2));
                        startActivityForResult(intent7, REQUEST_DECISION);
                        break;
                    case 11:
                        start.setText(R.string.end_text);
                        break;
                    default:
                        break;
                }
                step_counter++;
            }
        }

        else if(requestCode == REQUEST_DECISION) {
            if(data == null)
                return;
            Integer decision = data.getIntExtra("answer", 0);
            switch(step_counter)
            {
                case 2:
                    if(decision == 1)
                    {
                        injured = true;
                    }
                    else if(decision == 2)
                    {
                        injured = false;
                    }
                    Intent intent1 = new Intent(UnconsciousnessMainActivity.this, HelpStepWithInfoActivity.class);
                    intent1.putExtra("step_brief", getString(R.string.HUP_S3B));
                    intent1.putExtra("step_info", getString(R.string.HUP_S3I));
                    startActivityForResult(intent1, REQUEST_NEXT);
                    break;
                case 6:
                    if(decision == 1)
                    {
                        conscious = true;
                        Intent intent2 = new Intent(UnconsciousnessMainActivity.this, HelpSimpleStepActivity.class);
                        intent2.putExtra("step_brief", getString(R.string.HUP_S7BC));
                        startActivityForResult(intent2, REQUEST_NEXT);
                    }
                    else if(decision == 2)
                    {
                        conscious = false;
                        Intent intent2 = new Intent(UnconsciousnessMainActivity.this,  HelpStepWithPhotoActivity.class);
                        intent2.putExtra("step_brief", getString(R.string.HUP_S7BUC));
                        intent2.putExtra("image_resource", R.drawable.up_step7);
                        startActivityForResult(intent2, REQUEST_NEXT);
                    }
                    break;
                case 10:
                    if(decision == 1)
                    {
                        breath = true;
                        if(injured)
                        {
                            Intent intent3 = new Intent(UnconsciousnessMainActivity.this, HelpSimpleStepActivity.class);
                            intent3.putExtra("step_brief", getString(R.string.HUP_S11BU));
                            startActivityForResult(intent3, REQUEST_NEXT);
                        }
                        else {
                            Intent intent3 = new Intent(UnconsciousnessMainActivity.this,  HelpStepWithPhotoActivity.class);
                            intent3.putExtra("step_brief", getString(R.string.HUP_S11BNU));
                            intent3.putExtra("image_resource", R.drawable.up_step11);
                            startActivityForResult(intent3, REQUEST_NEXT);
                        }

                    }
                    else if(decision == 2)
                    {
                        breath = false;
                        Intent intent3 = new Intent(UnconsciousnessMainActivity.this, HelpSimpleStepActivity.class);
                        intent3.putExtra("step_brief", getString(R.string.HUP_S11BUN));
                        startActivityForResult(intent3, REQUEST_NEXT);
                    }
                    break;
                default:
                    break;
            }
            step_counter++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_unconsciousness_main, menu);
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

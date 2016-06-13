package com.example.samharris.spiderapp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;

public class Submission extends AppCompatActivity {

    TextView thanks;
    TextView timeDisplay;

    private String studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            studentName = extras.getString("KEY");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        thanks = (TextView) findViewById(R.id.textView2);

        timeDisplay = (TextView) findViewById(R.id.textView3);

        thanks.setText("Thank you " + studentName + ", for your submission");

        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        String time = String.valueOf(hours) + ":" + String.valueOf(minute) + ":" + String.valueOf(second);

        timeDisplay.setText("Submission recorded at " + time + ".");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }

        return true;
    }
}

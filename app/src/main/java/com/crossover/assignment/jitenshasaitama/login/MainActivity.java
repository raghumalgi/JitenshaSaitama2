package com.crossover.assignment.jitenshasaitama.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.Toast;

import com.crossover.assignment.jitenshasaitama.R;

public class MainActivity extends AppCompatActivity {
    long date;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal);

        final CalendarView base = (CalendarView) findViewById(R.id.calendarView);
        date = base.getDate();

        base.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
               // if (base.getDate() != date) {
                    Log.d("test","datae changed");
                    date = base.getDate();
                    Toast.makeText(view.getContext(), month + "/" + dayOfMonth + "/" + year, Toast.LENGTH_LONG).show();
                //}
            }
        });
    }
}
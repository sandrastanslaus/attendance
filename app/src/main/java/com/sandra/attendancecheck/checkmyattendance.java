package com.sandra.attendancecheck;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/**
 * Created by sandrathadeus on 3/20/17.
 */
public class checkmyattendance extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkmyattendance);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }










    }

package com.sandra.attendancecheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void onStudentButtonClick(View v) {

//        Intent i = new Intent(Settings.ACTION_ADD_ACCOUNT);
       // i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
      //  i.putExtra(Settings.EXTRA_AUTHORITIES, new String[]{"com.app.attendancecheck"});
//        startActivity(i);




         Intent i = new Intent(MainActivity.this, student_login.class);
        startActivity(i);

    }

    public void onTeacherButtonClick(View v) {
//        Intent i = new Intent(MainActivity.this, teacher_login.class);
//        startActivity(i);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(settingsIntent);
        }
            return true;
        }


    }

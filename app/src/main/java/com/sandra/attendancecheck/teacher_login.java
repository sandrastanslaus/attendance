package com.sandra.attendancecheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class teacher_login extends Activity {

    EditText email,tpass1;
    String emailstr, tpass1str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onBteacherClick(View v) {

        emailstr=email.getText().toString();
        tpass1str=tpass1.getText().toString();

        String method ="login";

        TeachBackgroundTask teachBackgroundTask= new TeachBackgroundTask(this);
        teachBackgroundTask.execute(method, emailstr,tpass1str);



        Intent i = new Intent(teacher_login.this, home.class);

        startActivity(i);

    }
    public void onBteacherRegisterClick(View view){
        Intent a = new Intent(teacher_login.this, teacher_registration.class);

        startActivity(a);
    }






}














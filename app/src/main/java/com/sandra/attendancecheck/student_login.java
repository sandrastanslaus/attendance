package com.sandra.attendancecheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class student_login extends Activity{

    EditText uname,pass1;
    String unamestr, pass1str;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

        uname= (EditText) findViewById(R.id.TFuname);
        pass1= (EditText) findViewById(R.id.TFpass1);



    }

    @Override


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    public void onBloginClick(View v) {


        unamestr= uname.getText().toString(); //getting info from user at opening app
        pass1str= pass1.getText().toString();

        String method= "login";

        //starting the ASYNC TASK  ie the stdBackgroundTask
        StdBackgroundTask stdBackgroundTask = new StdBackgroundTask(this);
        stdBackgroundTask.execute(method, unamestr, pass1str);  //passing method,name and password

// go to next task if login success write the code

       //Intent i = new Intent(student_login.this, checkmyattendance.class);

        //startActivity(i);

    }





    public void onBregisterClick(View view){
        Intent i = new Intent(student_login.this, student_registration.class);

        startActivity(i);
    }



}


















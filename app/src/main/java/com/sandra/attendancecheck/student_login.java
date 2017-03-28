package com.sandra.attendancecheck;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class student_login extends Activity{

    EditText uname,pass1;
    String unamestr, pass1str;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

//        uname= (EditText)findViewById(R.id.TFuname);
        pass1= (EditText)findViewById(R.id.TFpass1);

    }

    @Override


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    public void onBloginClick(View v) {

        RequestService requestService = new RequestService();
        requestService.execute();

    }



    public void onBregisterClick(View view){
        Intent i = new Intent(student_login.this, student_registration.class);

        startActivity(i);
    }


}










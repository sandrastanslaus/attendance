package com.sandra.attendancecheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class student_login extends Activity{

    EditText usernameEditText, passwordEditText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

        usernameEditText = (EditText)findViewById(R.id.TFuname);
        passwordEditText = (EditText)findViewById(R.id.TFpass1);

    }

    @Override


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    public void onBstudentloginClick(View v) {

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();


        try {
            String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");

            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

            PostRequestService postRequestService = new PostRequestService();
            postRequestService.execute("http://192.168.3.5/webapp/login.php", data);


        } catch (UnsupportedEncodingException e)
        {
            System.out.println(e.toString());
        }



    }



    public void onBstudentregistrationClick(View view){
        Intent i = new Intent(student_login.this, student_registration.class);

        startActivity(i);
    }


}










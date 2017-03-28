package com.sandra.attendancecheck;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class student_registration extends Activity {


   String namestr ,unamestr ,pass1str ,pass2str;

    //Progress Dialog
    private ProgressDialog pDialog;


    EditText name;
    EditText uname;
    EditText pass1;
    EditText pass2;


    Button Bregister;

    // url to create new product
    private static String url_register = "localhost/webapp/register.php ";

    // JSON Node names
    private static final String  TAG_SUCCESS = "success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_registration);

        //Edit Text

        name = (EditText) findViewById(R.id.TFname);
        uname = (EditText) findViewById(R.id.TFuname);
        pass1 = (EditText) findViewById(R.id.TFpass1);
        pass2 = (EditText) findViewById(R.id.TFpass2);

        // create button
        Bregister = (Button) findViewById(R.id.Bregister);


    }

}

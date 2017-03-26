package com.sandra.attendancecheck;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;


public class student_registration extends Activity {

     EditText TFname, TFuname, TFpass1, TFpass2;
     Button Bregister;

    String namestr ,unamestr ,pass1str ,pass2str;

  //  private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_registration);

        TFname= (EditText) findViewById(R.id.TFname);
        TFuname= (EditText) findViewById(R.id.TFuname);
         TFpass1= (EditText) findViewById(R.id.TFpass1);
         TFpass2= (EditText) findViewById(R.id.TFpass2);

        Bregister= (Button) findViewById(R.id.Bregister);
     //   progressDialog = new ProgressDialog(this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

public void onRegisterClick(View v)
{
    if(v.getId()==R.id.Bregister) {
        EditText name = (EditText) findViewById(R.id.TFname);
        EditText uname = (EditText) findViewById(R.id.TFuname);
        EditText pass1 = (EditText) findViewById(R.id.TFpass1);
        EditText pass2 = (EditText) findViewById(R.id.TFpass2);

        namestr = name.getText().toString();
        unamestr = uname.getText().toString();
        pass1str = pass1.getText().toString();
        pass2str = pass2.getText().toString();

        String method = "register";
        StdBackgroundTask stdBackgroundTask = new StdBackgroundTask(this);
        stdBackgroundTask.execute(method, namestr, unamestr, pass1str, pass2str);


        finish(); // close registration layout
    }

       // progressDialog = new ProgressDialog(this);

    if(!pass1str.equals(pass2str))
    {
        //popup msg
        Toast pass= Toast.makeText(student_registration. this, "Passwords don't match" ,Toast.LENGTH_SHORT );
        pass.show();
    }










}



}

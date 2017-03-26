package com.sandra.attendancecheck;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;



public class teacher_registration extends Activity {


    EditText TFteachername, TFemail,TFcourse, TFtpass1, TFtpass2;
    Button BteacherReg;

    String teachernamestr ,emailstr ,coursestr, tpass1str ,tpass2str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_registration);


        TFteachername= (EditText) findViewById(R.id.TFteachername);
        TFemail= (EditText) findViewById(R.id.TFemail);
        TFtpass1= (EditText) findViewById(R.id.TFtpass1);
        TFtpass2= (EditText) findViewById(R.id.TFtpass2);
        TFcourse= (EditText) findViewById(R.id.TFcourse);
        BteacherReg= (Button) findViewById(R.id.BTeacherReg);
        //   progressDialog = new ProgressDialog(this);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onBTeacherRegClick(View v)
    {
        if(v.getId()==R.id.BTeacherReg) {
            EditText teachername = (EditText) findViewById(R.id.TFteachername);
            EditText email = (EditText) findViewById(R.id.TFemail);
            EditText course = (EditText) findViewById(R.id.TFcourse);
            EditText tpass1 = (EditText) findViewById(R.id.TFtpass1);
            EditText tpass2 = (EditText) findViewById(R.id.TFtpass2);

            teachernamestr = teachername.getText().toString();
            emailstr = email.getText().toString();
            coursestr=course.getText().toString();
            tpass1str = tpass1.getText().toString();
            tpass2str = tpass2.getText().toString();

            String method = "register";
            TeachBackgroundTask teachBackgroundTask = new TeachBackgroundTask(this);
            teachBackgroundTask.execute(method, teachernamestr, emailstr,coursestr, tpass1str, tpass2str);
            finish();
        }


        //progressDialog= new ProgressDialog(this)

            if(!tpass1str.equals(tpass2str))
            {
                //popup msg
                Toast pass= Toast.makeText(teacher_registration. this, "Passwords don't match" ,Toast.LENGTH_SHORT );
                pass.show();
            }





        }




    }





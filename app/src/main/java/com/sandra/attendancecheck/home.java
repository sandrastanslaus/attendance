package com.sandra.attendancecheck;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class home extends Activity {


    // setting the date
    EditText date;
    DatePickerDialog datePickerDialog;

    // setting the course drop box
    private Spinner spinner1, spinner2;
    private Button btnSubmit;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        //initiate the date picker button
        date = (EditText) findViewById(R.id.date);

        //perform click event on edit text
        date.setOnClickListener( new View.OnClickListener()


        {

            @Override
            public void onClick (View v)
            {
                //calender class's instance and get current date, month and year from the calender

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); //current year
                int mMonth = c.get(Calendar.MONTH); //current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); //current day

                //date Picker dialog

                datePickerDialog = new DatePickerDialog(home.this, new DatePickerDialog.OnDateSetListener()
                {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                    {

                        //set day of month, month and year value in the edit

                        date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });

        addItemOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();


    }



 // add items into spinner dynamically
    public void addItemOnSpinner2()
    {
        spinner2= (Spinner)findViewById(R.id.spinner2);
        List<String> list = new ArrayList<>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection()
    {
        spinner1= (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

   }

    //get the selected dropdown list value



    public void addListenerOnButton()
    {
        spinner1= (Spinner) findViewById(R.id.spinner1);
        spinner2= (Spinner) findViewById(R.id.spinner2);
        btnSubmit=(Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener( new View.OnClickListener(){

       @Override
        public void onClick(View v)
        {
            Toast.makeText(home.this, "OnClickListener: " +
                            "\nSpinner 1 : " +String.valueOf(spinner1.getSelectedItem()) +
                            "\nSpinner 2 : " +String.valueOf(spinner2.getSelectedItem()),
                      Toast.LENGTH_SHORT).show();
                      }
                    });

                     }










    }

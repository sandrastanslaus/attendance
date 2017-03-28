package com.sandra.attendancecheck;

import android.content.Context;
import android.widget.AdapterView;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListPopupWindow;
import android.widget.Toast;



public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id )
    {

Toast.makeText(parent.getContext(),
        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
   Toast.LENGTH_SHORT).show();
}




    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

//TODO AUTO-generated method stub
   }

}
















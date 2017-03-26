package com.sandra.attendancecheck;

import android.widget.AdapterView;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * Created by sandrathadeus on 23/03/2017.
 */

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id )
    {

Toast.makeText(parent.getContext(),
        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
    Toast.LENGTH_SHORT).show();
}

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

        // TODO Auto-generated method stub
    }

}
















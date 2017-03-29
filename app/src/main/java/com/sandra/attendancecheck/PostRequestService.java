package com.sandra.attendancecheck;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestService extends AsyncTask<String, Void, String> {

    private final String LOG_TAG = PostRequestService.class.getSimpleName();

    @Override
    protected String doInBackground(String... params)
    {

        String urlString = params[0];
        String data = params[1];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        String loginJsonStr = null;

        try {
            URL url = new URL(urlString);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
            writer.write(data);
            writer.flush();

            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            StringBuilder stringBuilder = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null)
            {
                stringBuilder.append(line + "\n");
            }
            loginJsonStr = stringBuilder.toString();
            System.out.println(loginJsonStr);

            return loginJsonStr;


        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            return null;
        }
        finally
        {
            if(urlConnection != null)
            {
                urlConnection.disconnect();
            }
            if (reader != null)
            {
                try
                {
                    reader.close();
                } catch (final IOException e)
                {
                    Log.e(LOG_TAG, "Error ", e);
                }
            }
            return null;
        }

    }


    @Override
    protected void onPostExecute(String result) {
        if(result == null)
        {
            System.out.println("Something Happened");
        } else
        {
            switch (result)
            {
                case "student login failed":
                    System.out.println("Something Happened");

                    break;
                case "student login successful":
                    System.out.println("Login Successful");

                    break;

                case "student registration failed":
                    System.out.println("Registration Failed");

                    break;
                case "student registration successful":
                    System.out.println("Registration Successful");

                    break;

                case "teacher login failed":
                    System.out.println("Login Failed");

                    break;
                case "teacher login successful":
                    System.out.println("Login Successful");

                    break;

                case "teacher registration failed":
                    System.out.println("Registration Failed");

                    break;
                case "teacher registration successful":
                    System.out.println("Registration Successful");

                    break;
            }
        }
    }
}

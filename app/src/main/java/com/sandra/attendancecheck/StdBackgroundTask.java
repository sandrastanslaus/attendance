package com.sandra.attendancecheck;


import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;


public class StdBackgroundTask extends AsyncTask<String, Void, String> {


    private AlertDialog alertDialog;

    private Context ctx;

    StdBackgroundTask(Context ctx) //set a constructor
    {
       this.ctx= ctx;

    }
    @Override

    protected void onPreExecute()
    {
        alertDialog= new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("login information");
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://192.168.3.5/webapp/register.php";
        String login_url = "http://192.168.3.5/webapp/login.php";

        String method = params[0];

        if (method.equals("register")) {
            String name = params[1];
            String username = params[2];
            String password = params[3];


            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);


                //httpURLConnection.setDOInput(true);

                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("user", "UTF-8") +"="+URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") +"="+URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") +"="+URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close(); //closing output stream

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();  //closing input stream

                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Registration success...";


            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else {
            if (method.equals("login")) {

                String username = params[1];
                String password = params[2];

                try {
                    URL url = new URL(login_url); //creating an object of URL
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    //SETTING INFO TO THE SERVER
                    httpURLConnection.setDoOutput(true);
                    //getting response from the server
                    httpURLConnection.setDoInput(true);
                    //get output stream from url connection
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username, "UTF-8") + "&" +
                            URLEncoder.encode("password", "UTF-8")+ "="+URLEncoder.encode(password, "UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    //Getting response from the server
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String response = "";
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        response += line;

                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return response;


                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }


           return null;


    }




    @Override
    protected void onPostExecute(String result)
    {

        super.onPostExecute(result);


    if(result.equals("Registration success...")) //for registration

    {
    Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

    }
    else //case of login
    {
    alertDialog.setMessage(result);
    alertDialog.show();

    }
    }


   }

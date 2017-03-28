package com.sandra.attendancecheck;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestService extends AsyncTask<Void, Void, Void> {

    private final String LOG_TAG = RequestService.class.getSimpleName();

    @Override
    protected Void doInBackground(Void... params)
    {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        String loginJsonStr = null;

        try {
            URL url = new URL("http://192.168.3.5/webapp/login.php");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            if (inputStream == null)
            {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while((line = reader.readLine()) != null)
            {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0)
            {
                return null;
            }
            loginJsonStr = buffer.toString();
            System.out.println(loginJsonStr);

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

}

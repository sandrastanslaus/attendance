package com.sandra.attendancecheck;


public class RequestService {

    private String method;

    private String url;

    private String postData;


    public RequestService(String method, String url, String postData)
    {
        this.method = method;
        this.url = url;
        this.postData = postData;
    }

    public void send()
    {

    }

    public void send(String data)
    {

    }
}

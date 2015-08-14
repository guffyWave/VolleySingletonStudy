package com.appxperts.volleysingletonstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myWork(View v) {
        RequestQueue rq = VolleySingleton.getInstance().getRequestQueue();

        StringRequest request = new StringRequest(Request.Method.GET, "http://gufranscifi.appspot.com/GetAllScienceFactJSON", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Success Response " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("VolleyError  " + error.toString());
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    System.out.println("TimeoutError " + error.getMessage());
                } else if (error instanceof AuthFailureError) {
                    System.out.println("AuthFailureError " + error.getMessage());
                } else if (error instanceof ServerError) {
                    System.out.println("ServerError " + error.getMessage());
                } else if (error instanceof NetworkError) {
                    System.out.println("NetworkError " + error.getMessage());
                } else if (error instanceof ParseError) {
                    System.out.println("ParseError " + error.getMessage());
                }
            }
        });

        rq.add(request);

    }


}

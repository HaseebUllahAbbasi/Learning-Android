package com.dot.apidot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hitApi();
    }

    public synchronized void  hitApi()
    {
        TextView textView = (TextView) findViewById(R.id.text);
        final String[] data = {""};
// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener() {
            @Override
            public synchronized void onResponse(Object response) {
                Log.d(TAG, "onResponse: " + response.toString() ) ;
                textView.setText(response.toString());
                data[0] =response.toString();
            }
        }, new Response.ErrorListener() {
            @Override
            public synchronized void onErrorResponse(VolleyError error) {
            }
        });
        Log.d(TAG, "hitApi: "+ data[0]);

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void hitApi_2() {
        TextView textView = (TextView) findViewById(R.id.text);
// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.google.com";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, (Response.Listener) response ->
        {


        }, error -> {

        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
package com.melvax.youtubeapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.melvax.youtubeapi.adapter.Yadapter;
import com.melvax.youtubeapi.model.*;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String apiKey = "AIzaSyAJ5WxmFFB6GL3Gzvxmh4JcQoSkauAoNrg";
    private String query = "";
    private RecyclerView recyclerView;
    private EditText editText;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        editText = (EditText) findViewById(R.id.search);
        button = (Button) findViewById(R.id.button);

        //getVideos();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVideos();
            }
        });
    }


    private void getVideos() {

        query = editText.getText().toString();
        String youtubeUrl = "https://www.googleapis.com/youtube/v3/search?&maxResults=50&part=snippet&q=" + query + "&type=video&key=" + apiKey;

        StringRequest videosRequest = new StringRequest(youtubeUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Contracts as Java object
                Example example = new Gson().fromJson(response, Example.class);

                setAdapter(example);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Contracts", "Error");
            }
        });

        Volley.newRequestQueue(this).add(videosRequest);
    }

    private void setAdapter(Example example) {
        Yadapter adapter = new Yadapter(example);
        //adapter.setOnContractSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }
}

package com.example.unit1demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.unit1demo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Headers;

public class APIActivity extends AppCompatActivity {
    public static final String TAG = "APIActivity";

    //All API Requests:  base url + specific endpoint + parameters/queries

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String NOW_PLAYING_ENDPOINT = "movie/now_playing";
    public static final String API_QUERY = "?api_key=";
    public static final String API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed";

    AsyncHttpClient client;

    TextView tvResponse;
    Button btnRequest;
    Button btnToRVActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        //1.) Initializes everything:
        client = new AsyncHttpClient();

        tvResponse = findViewById(R.id.tvResponse);
        btnRequest = findViewById(R.id.btnRequest);
        btnToRVActivity = findViewById(R.id.btnToRV);


        //2.) Set btn onClickListeners here:
        //2a.) btnRequest --> to makeRequest():
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRequest();
            }
        });

        //2b.) btnToRVActivity --> to go to RVActivity:
        btnToRVActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRVActivity = new Intent(APIActivity.this, RVActivity.class);
                startActivity(toRVActivity);
            }
        });

    }

    public void makeRequest(){
        //1.) Format your url:
        String url = BASE_URL + NOW_PLAYING_ENDPOINT + API_QUERY + API_KEY;
        Log.d(TAG, "url used:  " + url);


        //2.) Run your url with your AsyncHttpClient:
        //Use client.get()
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                JSONObject response = json.jsonObject;
                try {
                    JSONArray results = response.getJSONArray("results");
                    JSONObject firstMovie = results.getJSONObject(0);
                    tvResponse.setText("First movie:  " + firstMovie.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e(TAG, "Error getting to url:  " + response);
            }
        });
    }




























    /*
    Just in case something goes wrong LOL:
     //1.) Format your url:
        String url = BASE_URL+NOW_PLAYING_ENDPOINT + API_QUERY + API_KEY;
        Log.d(TAG, "url used: " + url);


        //2.) Run your url with your AsyncHttpClient:
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                tvResponse.setText(" API Response:  " + json.toString());
                try {
                    JSONArray resultsArray = json.jsonObject.getJSONArray("results");
                    Log.d(TAG, "resultsArray = " + resultsArray.toString());
                    JSONObject firstMovie = resultsArray.getJSONObject(0);
                    Log.d(TAG, "firstMovie = " + firstMovie.toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e(TAG, "Error getting data from API: " + response);
            }
        });



     */

}
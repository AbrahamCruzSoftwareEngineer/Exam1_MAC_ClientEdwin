package com.evolutiondso.www.exam1mac_client;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.evolutiondso.www.exam1mac_client.entities.Student;
import com.google.android.gms.common.api.Result;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate: ");

        getJSON();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://www.mocky.io/v2/57a4dfb40f0000821dc9a3b8")
                .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    // Read data on the worker thread
                    final String responseData = response.body().string();

                    // Run view-related code back on the main thread
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Log.d(TAG, "run: " + responseData);
                                Gson gson = new Gson();
                                Student obj = gson.fromJson(responseData, Student.class);
                                String lista = obj.getAge();
                                Log.d(TAG, "onCreate: " + lista);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });


                }

                private void getJSON() {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    Log.d(TAG, "getJSON: ");

                    StringBuilder result = new StringBuilder();
                    HttpURLConnection urlConnection = null;

                    try {
                        URL url = new URL("http://www.mocky.io/v2/57a4dfb40f0000821dc9a3b8");
                        urlConnection = (HttpURLConnection) url.openConnection();
                        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                        String line;
                        while ((line = reader.readLine()) != null) {
                            result.append(line);
                        }

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "getJSON: " + result.toString());
                    try {
                        Gson gson = new Gson();
                        Student obj = gson.fromJson(result.toString(), Student.class);
                        String lista = obj.getAge();
                        Log.d(TAG, "Result JSON: " + lista);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }




}

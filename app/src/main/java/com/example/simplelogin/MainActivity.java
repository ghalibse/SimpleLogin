package com.example.simplelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private TextView user;
    private TextView pass;
    private Button mbutton;
    String url = "http://www.mocky.io/v2/57a4dfb40f0000821dc9a3b8";

    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (TextView) findViewById(R.id.txt1);
        pass = (TextView) findViewById(R.id.txt2);
        mbutton = (Button) findViewById(R.id.btn1);

    }

    public void doMagic(View view) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();

                Type listType = new TypeToken<List<Student>>() {
                }.getType();

                Gson gson = new GsonBuilder().create();
                students = gson.fromJson(json, listType);

                for (Student  i : students){
                    Log.d(TAG, "onResponse: " + i.toString());
                }

            }
        });

    }
}

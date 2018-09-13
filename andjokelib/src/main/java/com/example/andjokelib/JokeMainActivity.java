package com.example.andjokelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class JokeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_main);

        String joke = "No Joke!";
        Intent intent = getIntent();
        if(intent != null) {
            joke = intent.getExtras().getString("joke");
        }

        TextView jokeTv = findViewById(R.id.jokeTv);
        jokeTv.setText(joke);

    }
}

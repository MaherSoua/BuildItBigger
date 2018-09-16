package com.mahersoua.andjokelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mahersoua.andjokelib.R.layout.activity_joke_main);

        String joke = "No Joke!";
        Intent intent = getIntent();
        if(intent != null) {
            joke = intent.getExtras().getString("joke");
        }

        TextView jokeTv = findViewById(com.mahersoua.andjokelib.R.id.jokeTv);
        jokeTv.setText(joke);

    }
}

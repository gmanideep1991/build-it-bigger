package com.deepu.android.jokeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        getSupportFragmentManager().beginTransaction().replace(R.id.joke_fragment_paid,JokeActivityFragmentPaid.newInstance(getIntent().getStringExtra(getString(R.string.joke)))).commit();
    }
}

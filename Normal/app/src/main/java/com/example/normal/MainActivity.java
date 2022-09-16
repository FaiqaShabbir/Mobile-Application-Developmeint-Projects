package com.example.normal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
        protected void onResume() {
        super.onResume();
        Log.i("faiqa", "i am faiqa");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("zainab", "i am zainab");
        Log.i("shifa", "shhi");
    }
}
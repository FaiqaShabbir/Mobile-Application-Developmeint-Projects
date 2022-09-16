package com.example.sendplaintext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        String value = getIntent().getStringExtra("Email");
        TextView txtView = findViewById(R.id.to);
        txtView.setText(value);
    }
}
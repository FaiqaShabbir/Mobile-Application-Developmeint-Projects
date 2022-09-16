package com.example.sendplaintext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class activity_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Spinner spinner = findViewById(R.id.spinner1);
        String months[] = {"Jan", "Feb", "March"};
        ArrayAdapter adapter = new //provides view of each object in collection of object
                ArrayAdapter<String>(this,

                android.R.layout.simple_list_item_1, months);
        spinner.setAdapter(adapter);
    }
}
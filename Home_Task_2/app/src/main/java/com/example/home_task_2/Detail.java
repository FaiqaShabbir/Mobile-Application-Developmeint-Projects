package com.example.home_task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class Detail extends AppCompatActivity {
    EditText etTitle, etDesc;
    Switch switchCompleted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        etTitle = findViewById(R.id.tvtitle);
        etDesc = findViewById(R.id.description);
        switchCompleted = findViewById(R.id.swCompleted);

    }

    public void Done(View view) {
        String title = etTitle.getText().toString();
        String desc = etDesc.getText().toString();
        boolean isC = switchCompleted.isChecked();

        Intent intent = new Intent();


        intent.putExtra("Title", title);
        intent.putExtra("DESC", desc);
        intent.putExtra("ISC", isC);


        Detail.this.setResult(RESULT_OK, intent);
        Detail.this.finish();
    }
}

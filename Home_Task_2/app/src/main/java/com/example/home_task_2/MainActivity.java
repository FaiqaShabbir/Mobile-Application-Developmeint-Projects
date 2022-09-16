package com.example.home_task_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ToDoItemAdaptor adapter;
    List<ToDoItem> toDoItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoItemList.add(new ToDoItem(1, "ItemA", "Some Text Here...", false));
        toDoItemList.add(new ToDoItem(2, "ItemB", "Some Text Here...", false));
        toDoItemList.add(new ToDoItem(3, "ItemC", "Some Text Here...", false));
        toDoItemList.add(new ToDoItem(4, "ItemD", "Some Text Here...", false));

        adapter = new ToDoItemAdaptor();
        adapter.list = toDoItemList;
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toDoItemList.get(position);
            }
        });


    }

    public void onSave(View view) {
        Intent intent = new Intent(MainActivity.this, Detail.class);
        startActivityForResult(intent, 345);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 345){
            Log.i("SECACODE", "RequestCode");
            if(resultCode != RESULT_CANCELED){
                String title = data.getStringExtra("Title");
                String desc = data.getStringExtra("DESC");
                boolean bIsComp = data.getBooleanExtra("ISC", false);

                toDoItemList.add(new ToDoItem(toDoItemList.size()+1, title, desc, bIsComp));
                adapter.notifyDataSetChanged();
            }

        }
    }
/*
    @Override
    protected void onDestroy() {
        super.onDestroy();
        WriteDataToFile();
       // ReadDataFromFile();
    }

    void WriteDataToFile(){
       // File sdcard = Environment.getExternalStorageDirectory();
        File sdcard = this.getFilesDir();  //this means context

        File dir = new File(sdcard.getAbsolutePath() + "/secA/");
        if(dir.exists()!=true)
            dir.mkdir();
        dir.mkdir();
        File file = new File(dir, "sample.txt");
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            // os.write("Some text for file..........".getBytes());
            for (ToDoItem item: toDoItemList){
                os.write(item.toString().getBytes());
            }
            Log.i("FAIQA", "Written Successfully!!");
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void ReadDataFromFile(){
        File sdcard = Environment.getExternalStorageDirectory();
        File dir = new File(sdcard.getAbsolutePath() + "/text/");
        dir.mkdir();
        File file = new File(dir, "sample.txt");
        FileInputStream is = null;
        try {
            is = new FileInputStream(file);
            int byteCount = 0;
            StringBuilder stringBuilder = new StringBuilder();
            do {
                byte[] buffer = new byte[1024];
                byteCount = is.read(buffer);
                stringBuilder.append(new String(buffer));
            }while(byteCount!=-1);
            Log.i("Faiqa", "Read Successfully!!!");
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
package com.example.assignm_1_bscs_19011519_006;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "SupervisorSelectionForm.txt";
    List<SupervisorSelectionForm> mylist ;
    RecyclerView recyclerView;
    SupervisorSelectionFormAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.FormRecord);
        mylist = new ArrayList<>();

        mylist = dataStorage.readFromFile(getApplicationContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SupervisorSelectionFormAdapter();
        adapter.setSupervisorSelectionFormList(mylist);
        recyclerView.setAdapter(adapter);

    }

    public void onAddClick(View view) {
        Intent intent = new Intent(MainActivity.this, SupervisorSelection.class);
        startActivityForResult(intent, 345);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 345)
        {
            if(resultCode != RESULT_CANCELED) {

                String Date = data.getStringExtra("Date");
                String CandidateName = data.getStringExtra("CandidateName");
                String FatherName = data.getStringExtra("FatherName");
                String RegistrationNo = data.getStringExtra("RegistrationNo");
                String SupervisorNames = data.getStringExtra("SupervisorNames");
                String ResearchTopic1 = data.getStringExtra("ResearchTopic1");
                String Summary1 = data.getStringExtra("Summary1");
                String SupervisorSignature1 = data.getStringExtra("SupervisorSignature1");
                String ResearchTopic2 = data.getStringExtra("ResearchTopic2");
                String Summary2 = data.getStringExtra("Summary2");
                String SupervisorSignature2 = data.getStringExtra("SupervisorSignature2");
                String ResearchTopic3 = data.getStringExtra("ResearchTopic3");
                String Summary3 = data.getStringExtra("Summary3");
                String SupervisorSignature3 = data.getStringExtra("SupervisorSignature3");

                mylist.add(new SupervisorSelectionForm(mylist.size()+1, Date, CandidateName, FatherName, RegistrationNo, SupervisorNames,
                        ResearchTopic1, Summary1, SupervisorSignature1, ResearchTopic2, Summary2, SupervisorSignature2, ResearchTopic3,
                        Summary3, SupervisorSignature3, false));
                adapter.notifyDataSetChanged();
            }
        }

    }

}
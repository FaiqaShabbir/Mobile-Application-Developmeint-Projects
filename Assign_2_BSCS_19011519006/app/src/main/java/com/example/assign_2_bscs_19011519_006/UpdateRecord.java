package com.example.assign_2_bscs_19011519_006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateRecord extends AppCompatActivity {

    EditText Sname, Fname, RegNo, Synop1, Summ1, Sign1, Synop2, Summ2, Sign2, Synop3, Summ3, Sign3;
    Button update_button;

    String StudentName, FatherName, RegistrationNo, Synopsis1, Summary1, Signature1,
            Synopsis2, Summary2, Signature2, Synopsis3, Summary3, Signature3;
    DBHelper2 DB;
    SupervisorModel ssf = new SupervisorModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);

        Sname = findViewById(R.id.edt_name1);
        Fname = findViewById(R.id.edt_Fname1);
        RegNo = findViewById(R.id.edt_reg1);
        Synop1 = findViewById(R.id.edt_synop11);
        Summ1 = findViewById(R.id.edt_sum11);
        Sign1 = findViewById(R.id.edt_sign11);
        Synop2 = findViewById(R.id.edt_synop21);
        Summ2 = findViewById(R.id.edt_sum21);
        Sign2 = findViewById(R.id.edt_sign21);
        Synop3 = findViewById(R.id.edt_synop31);
        Summ3 = findViewById(R.id.summ3);
        Sign3 = findViewById(R.id.edt_sign31);

       // recyclerView = findViewById(R.id.receive);

//        updateAdaptor = new UpdateAdaptor(UpdateRecord.this, this, StudentName, FatherName, RegistrationNo, Synopsis1,
//                Summary1, Signature1, Synopsis2, Summary2, Signature2, Synopsis3, Summary3, Signature3);

        update_button = findViewById(R.id.btn_updateRecord);
        findViewById(R.id.btn_cancelUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateRecord.this, FetchData.class);
                startActivity(intent);
            }
        });
        //First we call this
        getAndSetIntentData();

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("sname") && getIntent().hasExtra("fname") &&
                getIntent().hasExtra("regno") && getIntent().hasExtra("syno1")
        && getIntent().hasExtra("summ1") && getIntent().hasExtra("sign1")&&
                getIntent().hasExtra("syno2")
        && getIntent().hasExtra("summ2") && getIntent().hasExtra("sign2")
                && getIntent().hasExtra("syno3")
        && getIntent().hasExtra("summ3") && getIntent().hasExtra("sign3"))
        {
            //Getting Data from Intent
            StudentName = getIntent().getStringExtra("sname");
            FatherName = getIntent().getStringExtra("fname");
            RegistrationNo = getIntent().getStringExtra("regno");
            Synopsis1 = getIntent().getStringExtra("syno1");
            Summary1 = getIntent().getStringExtra("summ1");
            Signature1 = getIntent().getStringExtra("sign1");
            Synopsis2 = getIntent().getStringExtra("syno2");
            Summary2 = getIntent().getStringExtra("summ2");
            Signature2 = getIntent().getStringExtra("sign2");
            Synopsis3 = getIntent().getStringExtra("syno3");
            Summary3 = getIntent().getStringExtra("summ3");
            Signature3 = getIntent().getStringExtra("sign3");

            //Setting Intent Data
            Sname.setText(StudentName);
            Fname.setText(FatherName);
            RegNo.setText(RegistrationNo);
            Synop1.setText(Synopsis1);
            Summ1.setText(Summary1);
            Sign1.setText(Signature1);
            Synop2.setText(Synopsis2);
            Summ2.setText(Summary2);
            Sign2.setText(Signature2);
            Synop3.setText(Synopsis3);
            Summ3.setText(Summary3);
            Sign3.setText(Signature3);


            DB = new DBHelper2(this);
            Log.d("stev", StudentName+" "+FatherName+" "+RegistrationNo);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickUpdate(View view) {

        Boolean checkUpdateData = DB.updateUserData(ssf.setStudentName(Sname.getText().toString()), ssf.setFatherName(Fname.getText().toString()),
                ssf.setRegistrationNo(RegNo.getText().toString()),
                ssf.setSynop1(Synop1.getText().toString()),
                ssf.setSumm1(Summ1.getText().toString()),
                ssf.setSign1(Sign1.getText().toString()),
                ssf.setSynop2(Synop2.getText().toString()),
                ssf.setSumm2(Summ2.getText().toString()),
                ssf.setSign2(Sign2.getText().toString()),
                ssf.setSynop3(Synop3.getText().toString()),
                ssf.setSumm3(Summ3.getText().toString()),
                ssf.setSign3(Sign3.getText().toString()));
        if (checkUpdateData == true){
            Toast.makeText(UpdateRecord.this, "Data Updated Successfully!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), FetchData.class));
        }
        else {
            Toast.makeText(UpdateRecord.this, "Unable to update data!", Toast.LENGTH_SHORT).show();
        }

    }
}
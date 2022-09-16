package com.example.assignm_1_bscs_19011519_006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class SupervisorSelection extends AppCompatActivity {

    private static final String FILE_NAME = "SupervisorSelectionForm.txt";

    EditText edt_CandidateName, edt_FatherName, edt_RegistrationNo, edt_SupervisorsNames,
            edt_ResearchTopic1, edt_Summary1, edt_SupervisorSignature1, edt_ResearchTopic2, edt_Summary2,
            edt_SupervisorSignature2, edt_ResearchTopic3, edt_Summary3, edt_SupervisorSignature3, edt_Date;

    RadioButton rd1, rd2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_selection);

        edt_Date = findViewById(R.id.edt_date);
        edt_CandidateName = findViewById(R.id.edt_CName);
        edt_FatherName = findViewById(R.id.edt_Fname);
        edt_RegistrationNo = findViewById(R.id.edt_reg);
        edt_SupervisorsNames = findViewById(R.id.edt_super);
        edt_ResearchTopic1 = findViewById(R.id.edt_synop);
        edt_Summary1 = findViewById(R.id.edt_summ);
        edt_SupervisorSignature1 = findViewById(R.id.edt_sign);
        edt_ResearchTopic2 = findViewById(R.id.edt_synop2);
        edt_Summary2 = findViewById(R.id.edt_summ2);
        edt_SupervisorSignature2 = findViewById(R.id.edt_sign2);
        edt_ResearchTopic3 = findViewById(R.id.edt_synop3);
        edt_Summary3 = findViewById(R.id.edt_summ3);
        edt_SupervisorSignature3 = findViewById(R.id.edt_sign3);

        rd1 = findViewById(R.id.rd_1);
        rd2 = findViewById(R.id.rd_2);


    }

    public void onSendClick(View view) {

        String CandidateName = edt_CandidateName.getText().toString();
        String FatherName = edt_FatherName.getText().toString();
        String RegistrationNo = edt_RegistrationNo.getText().toString();
        String SupervisorNames = edt_SupervisorsNames.getText().toString();
        String ResearchTopic1 = edt_ResearchTopic1.getText().toString();
        String Summary1 = edt_Summary1.getText().toString();
        String SupervisorSignature1 = edt_SupervisorSignature1.getText().toString();
        String ResearchTopic2 = edt_ResearchTopic2.getText().toString();
        String Summary2 = edt_Summary2.getText().toString();
        String SupervisorSignature2 = edt_SupervisorSignature2.getText().toString();
        String ResearchTopic3 = edt_ResearchTopic3.getText().toString();
        String Summary3 = edt_Summary3.getText().toString();
        String SupervisorSignature3 = edt_SupervisorSignature3.getText().toString();
        String Date = edt_Date.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("Date", Date);
        intent.putExtra("CandidateName", CandidateName);
        intent.putExtra("FatherName", FatherName);
        intent.putExtra("RegistrationNo", RegistrationNo);
        intent.putExtra("SupervisorNames", SupervisorNames);
        intent.putExtra("ResearchTopic1", ResearchTopic1);
        intent.putExtra("Summary1", Summary1);
        intent.putExtra("SupervisorSignature1", SupervisorSignature1);
        intent.putExtra("ResearchTopic2", ResearchTopic2);
        intent.putExtra("Summary2", Summary2);
        intent.putExtra("SupervisorSignature2", SupervisorSignature2);
        intent.putExtra("ResearchTopic3", ResearchTopic3);
        intent.putExtra("Summary3", Summary3);
        intent.putExtra("SupervisorSignature3", SupervisorSignature3);

        SupervisorSelection.this.setResult(RESULT_OK, intent);
        SupervisorSelection.this.finish();


    }

    public void onClickWrite(View view) {
        String Date = edt_Date.getText().toString();
        String CandidateName = edt_CandidateName.getText().toString();
        String FatherName = edt_FatherName.getText().toString();
        String RegistrationNo = edt_RegistrationNo.getText().toString();
        String SupervisorNames = edt_SupervisorsNames.getText().toString();
        String ResearchTopic1 = edt_ResearchTopic1.getText().toString();
        String Summary1 = edt_Summary1.getText().toString();
        String SupervisorSignature1 = edt_SupervisorSignature1.getText().toString();
        String ResearchTopic2 = edt_ResearchTopic2.getText().toString();
        String Summary2 = edt_Summary2.getText().toString();
        String SupervisorSignature2 = edt_SupervisorSignature2.getText().toString();
        String ResearchTopic3 = edt_ResearchTopic3.getText().toString();
        String Summary3 = edt_Summary3.getText().toString();
        String SupervisorSignature3 = edt_SupervisorSignature3.getText().toString();
        FileOutputStream fos = null;
        SupervisorSelectionForm s = new SupervisorSelectionForm(1, Date, CandidateName, FatherName, RegistrationNo, SupervisorNames, ResearchTopic1, Summary1, SupervisorSignature1, ResearchTopic2, Summary2, SupervisorSignature2, ResearchTopic3, Summary3, SupervisorSignature3, true);

        try {

            fos = openFileOutput(FILE_NAME, MODE_APPEND); //can also write as MODE_APPEND | MODE_PRIVATE
            fos.write(s.toString().getBytes());
            fos.write("\n".getBytes());
//            fos.write(CandidateName.getBytes());
//            fos.write(FatherName.getBytes());
//            fos.write(RegistrationNo.getBytes());
//            fos.write(SupervisorNames.getBytes());
//            fos.write(ResearchTopic1.getBytes());
//            fos.write(Summary1.getBytes());
//            fos.write(SupervisorSignature1.getBytes());
//            fos.write(ResearchTopic2.getBytes());
//            fos.write(Summary2.getBytes());
//            fos.write(SupervisorSignature2.getBytes());
//            fos.write(ResearchTopic3.getBytes());
//            fos.write(Summary3.getBytes());
//            fos.write(SupervisorSignature3.getBytes());

            fos.flush();
            fos.close();

//            edt_Date.getText().clear();
//            edt_CandidateName.getText().clear();
//            edt_FatherName.getText().clear();
//            edt_RegistrationNo.getText().clear();
//            edt_SupervisorsNames.getText().clear();
//            edt_ResearchTopic1.getText().clear();
//            edt_Summary1.getText().clear();
//            edt_SupervisorSignature1.getText().clear();
//            edt_ResearchTopic2.getText().clear();
//            edt_Summary2.getText().clear();
//            edt_SupervisorSignature2.getText().clear();
//            edt_ResearchTopic3.getText().clear();
//            edt_Summary3.getText().clear();
//            edt_SupervisorSignature3.getText().clear();

            Toast.makeText(this, "Saved to" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
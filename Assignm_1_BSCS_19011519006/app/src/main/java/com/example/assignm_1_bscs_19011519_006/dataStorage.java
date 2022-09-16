package com.example.assignm_1_bscs_19011519_006;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dataStorage {
    private static final String FILE_NAME = "SupervisorSelectionForm.txt";

    public static List<SupervisorSelectionForm> readFromFile(Context context) {
        Log.d("Faiqa1", "onCreate: " + "called readfromfile");
        List<SupervisorSelectionForm> ssfForm = new ArrayList<>();
        File path = context.getFilesDir();
        File readFrom = new File(path, FILE_NAME);
        try {
            BufferedReader br = new BufferedReader(new FileReader(readFrom));
            String line = "";
            while ((line = br.readLine()) != null) {
                SupervisorSelectionForm ssf = ssfLinetoModel(line);
                ssfForm.add(ssf);
                Log.d("Faiqa1", "onCreate: " + line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ssfForm;
    }
    public static SupervisorSelectionForm ssfLinetoModel(String data){
        String[] values = data.split(",");
        int ssfFormID = Integer.parseInt(values[0].trim());
        String Date = values[1].trim();
        String CandidateName = values[2].trim();
        String FatherName = values[3].trim();
        String RegistrationNo = values[4].trim();
        String SupervisorNames = values[5].trim();
        String ResearchTopic1 = values[6].trim();
        String Summary1 = values[7].trim();
        String SupervisorSignature1 = values[8].trim();
        String ResearchTopic2 = values[9].trim();
        String Summary2 = values[10].trim();
        String SupervisorSignature2 = values[11].trim();
        String ResearchTopic3 = values[12].trim();
        String Summary3 = values[13].trim();
        String SupervisorSignature3 = values[14].trim();

        SupervisorSelectionForm mymodel = new SupervisorSelectionForm(ssfFormID,Date,CandidateName,FatherName,RegistrationNo,SupervisorNames,
                ResearchTopic1, Summary1, SupervisorSignature1, ResearchTopic2, Summary2,
                SupervisorSignature2, ResearchTopic3, Summary3, SupervisorSignature3, false);
        return mymodel;
    }
}

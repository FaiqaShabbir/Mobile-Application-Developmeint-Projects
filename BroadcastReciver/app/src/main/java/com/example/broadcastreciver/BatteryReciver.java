package com.example.broadcastreciver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class BatteryReciver extends BroadcastReceiver {

    TextView tv;
    BatteryReciver(TextView tv){
        this.tv = tv;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int percentage = intent.getIntExtra("level", 0);
        if(percentage!=0){
            tv.setText(percentage+"%");
            tv.setTextColor(Color.WHITE);
        }
    }
}
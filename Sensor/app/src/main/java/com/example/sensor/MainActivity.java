package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1st we will take sensor manager and sensor service
        //returns multiple services related to multiple managers
        @SuppressLint("ServiceCast") SensorManager sensorManager = (SensorManager) getSystemService(SEARCH_SERVICE);
        if (sensorManager != null){
            Sensor proxySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            if (proxySensor != null){
                sensorManager.registerListener(this, proxySensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
    }

    // values changed due to event fired will be found in this sensor method
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT){
            ((TextView)findViewById(R.id.txt_sensor)).setText("Values: " + event.values[0]);

            if (event.values[0] > 0){
                Toast.makeText(this, "Object is Far", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Object is near", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
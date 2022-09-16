package com.example.melocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Initialize Variables
    Button btn;
    TextView txt1, txt2, txt3, txt4, txt5;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variables
        txt1 = findViewById(R.id.txt_1);
        txt2 = findViewById(R.id.txt_2);
        txt3 = findViewById(R.id.txt_3);
        txt4 = findViewById(R.id.txt_4);
        txt5 = findViewById(R.id.txt_5);

        btn = findViewById(R.id.location_btn);

        //Initialize fusedLocation
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


    }

    public void onClickGetLocation(View view) {
        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // permission granted
            getLocation();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                //Initialize variable
                Location location = task.getResult();
                if (location != null) {
                    try {
                        // Initialize geocoder
                        Geocoder geocoder = new Geocoder(MainActivity.this,
                                Locale.getDefault());
                        // Initialize address list
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1);
                        // set latitude
                        txt1.setText(Html.fromHtml("<font color= '#6200EE'><b>Latitude :</b><br></font>"
                                + addresses.get(0).getLongitude()));
                        // set longitude
                        txt2.setText(Html.fromHtml("<font color= '#6200EE'><b>Longitude :</b><br></font>"
                                + addresses.get(0).getLongitude()));
                        // set country name
                        txt3.setText(Html.fromHtml("<font color= '#6200EE'><b>Country Name :</b><br></font>"
                                + addresses.get(0).getCountryName()));
                        // set locality
                        txt4.setText(Html.fromHtml("<font color= '#6200EE'><b>Locality :</b><br></font>"
                                + addresses.get(0).getLocality()));
                        // set address
                        txt5.setText(Html.fromHtml("<font color= '#6200EE'><b>Address :</b><br></font>"
                                + addresses.get(0).getAddressLine(0)
                        ));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
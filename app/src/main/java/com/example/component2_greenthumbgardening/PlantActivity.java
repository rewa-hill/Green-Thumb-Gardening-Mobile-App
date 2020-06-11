package com.example.component2_greenthumbgardening;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class PlantActivity extends AppCompatActivity {

    TextView plantName_msg;
    TextView plantSciName_msg;
    TextView plantDesc_msg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);

        //Toolbar Settings
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        plantName_msg = findViewById(R.id.plantInfo_plantName);
        plantSciName_msg = findViewById(R.id.plantInfo_SciName);
        plantDesc_msg = findViewById(R.id.plantInfo_plantDesc);

        //Creates Intent
        Intent intent = getIntent();

        //Intent Details
        String plantName = intent.getStringExtra("plant_name");
        String plantSciName = intent.getStringExtra("plant_sci_name");
        String plantDesc = intent.getStringExtra("plant_desc");

        plantName_msg.setText(plantName);
        plantSciName_msg.setText(plantSciName);
        plantDesc_msg.setText(plantDesc);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}

package com.example.cupcakefactory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CmActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm);

        ImageButton OderCatogories = findViewById(R.id.OderCatogories);
        OderCatogories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CmActivity.this, CmcusoderActivity.class);
                startActivity(intent);
            }
        });
        ImageButton MakeCusOder = findViewById(R.id.MakeCusOder);
        MakeCusOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CmActivity.this, CmcatoderActivity.class);
                startActivity(intent);
            }
        });
        ImageButton ViewOder = findViewById(R.id.ViewOder);
        ViewOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CmActivity.this, CmviewoderActivity.class);
                startActivity(intent);
            }
        });
    }
}
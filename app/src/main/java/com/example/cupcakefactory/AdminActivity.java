package com.example.cupcakefactory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        ImageButton Addcuscupcakes = findViewById(R.id.Addcuscupcakes);
        Addcuscupcakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AddcupcakeadminActivity.class);
                startActivity(intent);
            }
        });
        ImageButton AddCategories = findViewById(R.id.AddCategories);
        AddCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AddcatadminActivity.class);
                startActivity(intent);
            }
        });
        ImageButton viewOder = findViewById(R.id.viewOder);
        viewOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AdminviewodersActivity.class);
                startActivity(intent);
            }
        });
    }
}
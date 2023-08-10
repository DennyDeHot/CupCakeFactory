package com.example.cupcakefactory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CmcusoderActivity extends AppCompatActivity {

    private TextView enterTheQuntTV;
    private TextView enterTheCupCakeTV;
    private TextView enterUserNameTV;

    private TableLayout tableLayout;

    private ArrayList<Category> category;

    private DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cmcusoder);



        dbHandler.openDB();

        TableLayout tableLayout = findViewById(R.id.tableLayout1);

        category = (ArrayList<Category>) dbHandler.getAllCategoryData();

        for (Category data : category) {
            TableRow tableRow = new TableRow(this);

            TextView textView1 = new TextView(this);
            textView1.setText(data.getCatName());
            tableRow.addView(textView1);

            TextView textView2 = new TextView(this);
            textView2.setText(data.getCatInclude());
            tableRow.addView(textView2);

            TextView textView3 = new TextView(this);
            textView3.setText(data.getCatPrice());
            tableRow.addView(textView3);
            // Add more TextViews for additional columns if needed

            tableLayout.addView(tableRow);
        }

        enterTheQuntTV = (TextView) findViewById(R.id.enterTheQunt);
        enterTheCupCakeTV = (TextView)findViewById(R.id.enterTheCupCake);
        enterUserNameTV = (TextView)findViewById(R.id.enterUserName);

        Button addToCart = findViewById(R.id.onClickAddToCart);
        addToCart.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String crtName = enterTheQuntTV.getText().toString();
                String crtCat = enterTheCupCakeTV.getText().toString();
                String crtQuan = enterUserNameTV.getText().toString();

                Cart cart = new Cart(crtName,crtCat,crtQuan);
                dbHandler.addToCart(cart);

                startActivity(new Intent(CmcusoderActivity.this, CmActivity.class));
                Toast.makeText(getApplicationContext(),
                        "Inserted to cart",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
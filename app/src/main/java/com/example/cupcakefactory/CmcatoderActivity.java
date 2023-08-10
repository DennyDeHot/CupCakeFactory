package com.example.cupcakefactory;

import static com.example.cupcakefactory.R.id.CartUname;

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
import java.util.List;

public class CmcatoderActivity extends AppCompatActivity {

    private TextView cuname;
    private TextView cupname;
    private TextView cqnty;

    private TableLayout tableLayout;

    private ArrayList<Cupcake> cupcake;

    private DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmcatoder);

        dbHandler.openDB();

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        cupcake = (ArrayList<Cupcake>) dbHandler.getAllCupcakeData();

        for (Cupcake data : cupcake) {
            TableRow tableRow = new TableRow(this);

            TextView textView1 = new TextView(this);
            textView1.setText(data.getCupcakeName());
            tableRow.addView(textView1);

            TextView textView2 = new TextView(this);
            textView2.setText(data.getPrice());
            tableRow.addView(textView2);

            // Add more TextViews for additional columns if needed

            tableLayout.addView(tableRow);
        }



        cuname = (TextView) findViewById(R.id.CartUname);
        cupname = (TextView)findViewById(R.id.CartCat);
        cqnty = (TextView)findViewById(R.id.CartQuan);



        Button addToCart = findViewById(R.id.addtocrt);
        addToCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String crtName = cuname.getText().toString();
                String crtCat = cupname.getText().toString();
                String crtQuan = cqnty.getText().toString();

                Cart cart = new Cart(crtName,crtCat,crtQuan);
                dbHandler.addToCart(cart);

                Intent intent = new Intent(CmcatoderActivity.this, CmActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),
                        "Inserted to cart",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
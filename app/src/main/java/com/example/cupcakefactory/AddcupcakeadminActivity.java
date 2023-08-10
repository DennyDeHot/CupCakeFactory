package com.example.cupcakefactory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddcupcakeadminActivity extends AppCompatActivity {

    private TextView cupID;
    private TextView cupName;
    private TextView cupPrice;
    private TextView cupQuan;

    private DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcupcakeadmin);

        cupID = (TextView)findViewById(R.id.CupcakeID);
        cupName = (TextView)findViewById(R.id.Cupcakename);
        cupPrice = (TextView)findViewById(R.id.Cupcakeprice);
        cupQuan = (TextView)findViewById(R.id.Cupquan);

        dbHandler.openDB();

        Button signupButton = findViewById(R.id.Addcupcake);
        signupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String cupid = cupID.getText().toString();
                String cupname = cupName.getText().toString();
                String cupprice = cupPrice.getText().toString();
                String cupquan = cupQuan.getText().toString();

                Cupcake cupK = new Cupcake(cupid,cupname,cupprice,cupquan);
                dbHandler.insertCupCake(cupK);

                Intent intent = new Intent(AddcupcakeadminActivity.this, AdminActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),
                        "Done",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
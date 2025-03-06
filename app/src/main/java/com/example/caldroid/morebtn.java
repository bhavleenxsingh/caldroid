package com.example.caldroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class morebtn extends AppCompatActivity {
Button btnsq, btncb, btnsqrt, btncbrt, btnprime, btnfibo, btnexp, btnotp, backhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_morebtn);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnsq = findViewById(R.id.btnsq);
        btncb = findViewById(R.id.btncb);
        btnsqrt = findViewById(R.id.btnsqrt);
        btncbrt = findViewById(R.id.btncbrt);
        btnexp = findViewById(R.id.btnexp);
        backhome = findViewById(R.id.backhome);

        Intent intentbackhome = new Intent(morebtn.this, MainActivity.class);
        Intent intentsq = new Intent(morebtn.this, square.class);
        Intent intentcube = new Intent(morebtn.this, cube.class);
        Intent intentsqrt = new Intent(morebtn.this, sqroot.class);
        Intent intentcbrt = new Intent(morebtn.this, cbrt.class);
        Intent intentexp = new Intent(morebtn.this, exp.class);


        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentbackhome);
            }
        });
        btnsq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentsq);
            }
        });

        btncb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentcube);
            }
        });

        btnsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentsqrt);
            }
        });

        btncbrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentcbrt);
            }
        });

        btnexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentexp);
            }
        });




    }
}
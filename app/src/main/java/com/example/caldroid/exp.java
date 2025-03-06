package com.example.caldroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class exp extends AppCompatActivity {
Button expbtn, expback, exphome;
EditText expno, exppower;
TextView expres;
double no, power, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exp);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        expbtn = findViewById(R.id.expbtn);
        expback = findViewById(R.id.expback);
        exphome = findViewById(R.id.exphome);
        expno = findViewById(R.id.expno);
        exppower = findViewById(R.id.exppower);
        expres = findViewById(R.id.expres);

        Intent intentexpback = new Intent(exp.this, morebtn.class);
        Intent intentexphome = new Intent(exp.this, MainActivity.class);

        expbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                no = Integer.parseInt(expno.getText().toString());
                power = Integer.parseInt(exppower.getText().toString());
                res = Math.pow(no, power);
                    DecimalFormat decfor = new DecimalFormat("##,##,###");
                    String formatno, formatpower, formatres;
                    formatno = decfor.format(no);
                    formatpower = decfor.format(power);
                    formatres = decfor.format(res);
                expres.setText(formatno + " ^ " + formatpower + " = " + formatres);
            }
                catch (Exception e){
                    Toast.makeText(exp.this, "Please Enter a Valid Number !", Toast.LENGTH_LONG ).show();
                }
            }

        });

        expback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentexpback);
            }
        });

        exphome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentexphome);
            }
        });

    }
}
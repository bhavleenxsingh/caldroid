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

public class cbrt extends AppCompatActivity {
Button cbrtbtn, cbrtbackbtn, cbrthomebtn;
EditText cbrtno;
TextView cbrtres;

double no, res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cbrt);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cbrtbtn = findViewById(R.id.cbrtbtn);
        cbrtbackbtn = findViewById(R.id.cbrtbackbtn);
        cbrthomebtn = findViewById(R.id.cbrthomebtn);
        cbrtno = findViewById(R.id.cbrtno);
        cbrtres = findViewById(R.id.cbrtres);

        Intent intentcbrtback = new Intent(cbrt.this, morebtn.class);
        Intent intentcbrthome = new Intent(cbrt.this, MainActivity.class);

        cbrtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    no = Double.parseDouble(cbrtno.getText().toString());
                    res = Math.cbrt(no);
                    DecimalFormat decfor = new DecimalFormat("##,##,###.####");
                    String formatno = decfor.format(no);
                    String formatres = decfor.format(res);
                    cbrtres.setText(formatres + " is the Cube Root of " + formatno);
                }
                catch (Exception e){
                    Toast.makeText(cbrt.this, "Please Enter a valid number", Toast.LENGTH_LONG).show();
                }

                }
        });

        cbrtbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentcbrtback);
            }
        });

        cbrthomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentcbrthome);
            }
        });


    }
}
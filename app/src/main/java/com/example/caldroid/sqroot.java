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

public class sqroot extends AppCompatActivity {
Button sqrtbtn, sqrtbackbtn, sqrthomebtn;
EditText sqrtno;
TextView sqrtres;
double no, res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sqroot);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sqrtbtn = findViewById(R.id.sqrtbtn);
        sqrtbackbtn = findViewById(R.id.sqrtbackbtn);
        sqrthomebtn = findViewById(R.id.sqrthomebtn);
        sqrtno = findViewById(R.id.sqrtno);
        sqrtres = findViewById(R.id.sqrtres);

        Intent intentsqrtback = new Intent(sqroot.this, morebtn.class);
        Intent intentsqrthome = new Intent(sqroot.this, MainActivity.class);

        sqrtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    no = Double.parseDouble(sqrtno.getText().toString());
                    res = Math.sqrt(no);
                    DecimalFormat decfor = new DecimalFormat("##,##,###.####");
                    String formatres = decfor.format(res);
                    sqrtres.setText(formatres + " is the square root of " + no);
                }
                catch (Exception e){
                    Toast.makeText(sqroot.this, "Please Enter a Valid Number !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sqrtbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentsqrtback);
            }
        });

        sqrthomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentsqrthome);
            }
        });
    }
}
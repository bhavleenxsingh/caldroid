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

public class MainActivity extends AppCompatActivity {
EditText firstno, secondno;
Button btnadd, btnsub, btnmul, btndiv, btnmore;
TextView resulttext;
double result;
int intresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        firstno = findViewById(R.id.firstno);
        secondno = findViewById(R.id.secondno);
        btnadd = findViewById(R.id.btnadd);
        btnsub = findViewById(R.id.btnsub);
        btnmul = findViewById(R.id.btnmul);
        btndiv = findViewById(R.id.btndiv);
        btnmore = findViewById(R.id.btnmore);
        resulttext = findViewById(R.id.resulttext);

        Intent more = new Intent(MainActivity.this, morebtn.class);

btnadd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try{
        double first = Double.parseDouble(firstno.getText().toString());
        double second = Double.parseDouble((secondno.getText().toString()));
    result = first + second;
        intresult = ((int) result);
        DecimalFormat decfor = new DecimalFormat("##,##,###");
        String formatres = decfor.format(intresult);
    resulttext.setText(formatres + " is the sum.");}

        catch (Exception e){
            Toast.makeText(MainActivity.this, "Please Enter a Valid Number !", Toast.LENGTH_LONG).show();
        }
    }
});

btnsub.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            double first = Double.parseDouble(firstno.getText().toString());
            double second = Double.parseDouble((secondno.getText().toString()));
            result = first - second;
            intresult = ((int) result);
            DecimalFormat decfor = new DecimalFormat("##,##,##,###");
            String formatres = decfor.format(intresult);
            resulttext.setText(formatres + " is the difference.");
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, "Please Enter a Valid Number !", Toast.LENGTH_LONG).show();
        }

    }
});

btnmul.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            double first = Double.parseDouble(firstno.getText().toString());
            double second = Double.parseDouble((secondno.getText().toString()));
            result = first * second;
            DecimalFormat decfor = new DecimalFormat("##,##,###");
            String formatres = decfor.format(result);
            resulttext.setText(formatres + " is the product.");
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, "Please Enter a Valid Number !", Toast.LENGTH_LONG).show();
        }
    }
});

btndiv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            double first = Double.parseDouble(firstno.getText().toString());
            double second = Double.parseDouble((secondno.getText().toString()));
            result = first / second;
            DecimalFormat decfor = new DecimalFormat("##,##,###.###");
            String formatres = decfor.format(result);
            resulttext.setText(formatres + " is the result.");
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, "Please Enter a Valid Number !", Toast.LENGTH_SHORT).show();
        }
    }
});

btnmore.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    startActivity(more);
    }
});

    }
}
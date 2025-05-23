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

public class square extends AppCompatActivity {
    Button sqbtn, sqbackbtn, sqhome;
    EditText sqno;
    TextView sqres;
    int sq, res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_square);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sqbtn = findViewById(R.id.sqbtn);
        sqbackbtn = findViewById(R.id.sqbackbtn);
        sqno = findViewById(R.id.sqno);
        sqhome = findViewById(R.id.sqhome);
        sqres = findViewById(R.id.sqres);

        Intent intentsqback = new Intent(square.this, morebtn.class);
        Intent intentsqhome = new Intent(square.this, MainActivity.class);
        sqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int sq = Integer.parseInt(sqno.getText().toString());
                    int res = sq * sq;
                    DecimalFormat decfor = new DecimalFormat("##,##,###");
                    String formatres = decfor.format(res);
                    sqres.setText(formatres + " is the square of " + sq);
                }
                catch (Exception e){
                    Toast.makeText(square.this, "Please Enter a Valid Number !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sqbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentsqback);
            }
        });
        sqhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentsqhome);
            }
        });
    }
}
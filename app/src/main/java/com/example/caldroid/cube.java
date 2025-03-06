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

public class cube extends AppCompatActivity {

    Button cubebtn, cubebackbtn, cubehome;
    TextView cuberes;
    EditText cubeno;
    int no, res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cubebtn = findViewById(R.id.cubebtn);
        cubebackbtn = findViewById(R.id.cubebackbtn);
        cubehome = findViewById(R.id.cubehome);
        cuberes = findViewById(R.id.cuberes);
        cubeno = findViewById(R.id.cubeno);

        Intent cubebackintent = new Intent(cube.this, morebtn.class);
        Intent cubehomeintent = new Intent(cube.this, MainActivity.class);

        cubebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    no = Integer.parseInt(cubeno.getText().toString());
                    res = no * no;
                    DecimalFormat decfor = new DecimalFormat("##,##,###");
                    String formatres, formatno;
                    formatno = decfor.format(no);
                    formatres = decfor.format(res);
                    cuberes.setText(formatres + " is the cube of " + formatno);
                }
                catch(Exception e){
                    Toast.makeText(cube.this, "Please Enter a Valid Number !", Toast.LENGTH_LONG).show();
                }
                }

        });

        cubebackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(cubebackintent);
            }
        });

        cubehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(cubehomeintent);
            }
        });
    }
}
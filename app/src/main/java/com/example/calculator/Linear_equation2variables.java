package com.example.calculator;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Linear_equation2variables extends AppCompatActivity {
    TextView homescreen;
    private TextView textView;
    private EditText a1;
    private EditText b1;
    private EditText c1;
    private EditText a2;
    private EditText b2;
    private EditText c2;
    private TextView result;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_equation2variables);
        homescreen=findViewById(R.id.home_screen3);
        submit = findViewById(R.id.submitlinear2);
        result = findViewById(R.id.textView39);
        a1 = findViewById(R.id.editTextNumberSigned8);
        b1 = findViewById(R.id.editTextNumberSigned9);
        c1 = findViewById(R.id.editTextNumberSigned10);
        a2 = findViewById(R.id.editTextNumberSigned5);
        b2 = findViewById(R.id.editTextNumberSigned6);
        c2 = findViewById(R.id.editTextNumberSigned7);

        Intent intent = new Intent(this, MainActivity.class);
        homescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=a1.getText().toString();
                String b=b1.getText().toString();
                String c=c1.getText().toString();
                String d=a2.getText().toString();
                String e=b2.getText().toString();
                String f=c2.getText().toString();
                Float a1=Float.parseFloat(a);
                Float b1=Float.parseFloat(b);
                Float c1=Float.parseFloat(c);
                Float a2=Float.parseFloat(d);
                Float b2=Float.parseFloat(e);
                Float c2=Float.parseFloat(f);

                if((a1/a2)==(b1/b2) && (b1/b2)==(c1/c2)){
                    Toast.makeText(Linear_equation2variables.this, "Infinte Solutions", Toast.LENGTH_SHORT).show();
                }
                if((a1/a2)==(b1/b2) && (b1/b2) != (c1/c2)){
                    Toast.makeText(Linear_equation2variables.this, "No Solutions", Toast.LENGTH_SHORT).show();
                }
                if((a1/a2)!=(b1/b2) ){
                    Toast.makeText(Linear_equation2variables.this, "Unique Solution", Toast.LENGTH_SHORT).show();
                    float x=0;
                    float y=0;
                    x=(b1*c2-c1*b2)/(a1*b2-a2*b1);

                    y=(c1*a2-c2*a1)/(a1*b2-a2*b1);

                    result.setText("value of x= "+x+" ,\n"+"value of y= "+y);

                }
            }
        });
    }
    public void retry3(View v){
        Intent intent = new Intent(this,Linear_equation2variables.class);
        startActivity(intent);
        finish();
    }
}
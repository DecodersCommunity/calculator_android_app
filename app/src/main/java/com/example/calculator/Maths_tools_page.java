package com.example.calculator;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Maths_tools_page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_tools_page);

    }

    public void home(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void quadeqn(View v) {
        Intent intent = new Intent(this, Quadratic_Equation.class);
        startActivity(intent);

    }

    public void log_calculation(View v) {
        Intent intent = new Intent(this, Log_calculation.class);
        startActivity(intent);

    }

    public void linear_eqn2var(View v) {
        Intent intent = new Intent(this, Linear_equation2variables.class);
        startActivity(intent);

    }

    public void trignometry(View view) {
        Intent intent = new Intent(this, TrignometryActivity.class);
        startActivity(intent);
    }

    public void TempClick(View view) {
        Intent intent = new Intent(this, TempConvertor.class);
        startActivity(intent);
    }

    public void currency(View view) {
        Intent intent = new Intent(this, currency_converter.class);
        startActivity(intent);
    }
}
package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.calculator.databinding.ActivityTempConvertorBinding;

public class TempConvertor extends AppCompatActivity {
ActivityTempConvertorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTempConvertorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    public  void temp_home(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void temp_refresh(View view){
       binding.editTextNumberSigned.setText("");
       binding.editTextNumberSigned2.setText("");
       binding.textView37.setText("");
    }
    @SuppressLint("SetTextI18n")
    public void temp_result(View view){
        if (!binding.editTextNumberSigned.getText().toString().isEmpty() && binding.editTextNumberSigned2.getText().toString().isEmpty()){
            float c = Float.parseFloat(binding.editTextNumberSigned.getText().toString());
            float st = (float) (c* 1.8);
            float temp = (st)+ 32;
            binding.textView37.setText(binding.editTextNumberSigned.getText().toString()+" °C    =   "+ temp +" "+"°F");
        }else if (!binding.editTextNumberSigned2.getText().toString().isEmpty() && binding.editTextNumberSigned.getText().toString().isEmpty()){
            float f = Float.parseFloat(binding.editTextNumberSigned2.getText().toString());
            float f2 = (float) (f - 32);
            float temp = (float) ((f2) * 0.5555555555555556);
            binding.textView37.setText(binding.editTextNumberSigned2.getText().toString()+" °F    =   "+ temp +" "+"°C");
        }else if (!binding.editTextNumberSigned.getText().toString().isEmpty() &&!binding.editTextNumberSigned2.getText().toString().isEmpty() ){
            float c = Float.parseFloat(binding.editTextNumberSigned.getText().toString());
            float st = (float) (c* 1.8);
            float temp1 = (st)+ 32;

            float f = Float.parseFloat(binding.editTextNumberSigned2.getText().toString());
            float f2 = (float) (f - 32);
            float temp2 = (float) ((f2) * 0.5555555555555556);

            String fahrenheit = binding.editTextNumberSigned2.getText().toString()+" °F    =   "+ temp2 +" "+"°C";
            String celsius = binding.editTextNumberSigned.getText().toString()+" °C    =   "+ temp1 +" "+"°F" ;
            binding.textView37.setText(fahrenheit + "\n\n" + celsius);
        }
    }
}
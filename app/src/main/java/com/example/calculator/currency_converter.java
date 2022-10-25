package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import org.json.JSONException;
import org.json.JSONObject;

public class currency_converter extends AppCompatActivity {

    Button submit;
    SearchableSpinner from , to;
    String from_currency,to_currency;
    TextView answer;
    String ans,result_api;
    EditText value_to_convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        value_to_convert=findViewById(R.id.currency);

        submit=findViewById(R.id.currency_convertor);
        from=findViewById(R.id.from);
        to=findViewById(R.id.to);
        answer=findViewById(R.id.textView26);
        String[] box_list=  getResources().getStringArray(R.array.currency);


        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, box_list);
        to.setAdapter(adapter);
        from.setAdapter(adapter);
        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to_currency=parent.getItemAtPosition(position).toString().substring(0,3);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(currency_converter.this, "Select the Currency", Toast.LENGTH_SHORT).show();
            }
        });
        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from_currency=parent.getItemAtPosition(position).toString().substring(0,3);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(currency_converter.this, "Select the Currency", Toast.LENGTH_SHORT).show();
            }
        });



        submit.setOnClickListener(v -> {
            String amount=value_to_convert.getText().toString();
            if(amount==""){
                Toast.makeText(this, "Enter the amount for conversion", Toast.LENGTH_SHORT).show();
            }
            else{
                float amount_float=Float.parseFloat(amount);
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                //API key is used  f0500f203100c821ff6552ce from exchangerate.com //
                // the Api keyexpired after free trial is finished//
                String myUrl = "https://v6.exchangerate-api.com/v6/f0500f203100c821ff6552ce/pair/"+from_currency+"/"+to_currency;

                StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
                        response -> {
                            try{
                                //Create a JSON object containing information from the API.
                                JSONObject myJsonObject = new JSONObject(response);
                                result_api=myJsonObject.getString("result");

                                if(result_api.equals("success")){
                                    ans=myJsonObject.getString("conversion_rate");
                                    Toast.makeText(this, "conversion rate "+ans, Toast.LENGTH_SHORT).show();
                                    float ans_in_float=Float.parseFloat(ans);
                                    float final_answer=ans_in_float*amount_float;
                                    String final_ans=Float.toString(final_answer);
                                    answer.setText(final_ans);
                                }
                                else{
                                    Toast.makeText(this, "API is expired", Toast.LENGTH_SHORT).show();
                                }

                            } catch (JSONException e) {
                                Toast.makeText(this, "Error in the connectivity", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                            }
                        },
                        volleyError -> {
                            Toast.makeText(currency_converter.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                );
                requestQueue.add(myRequest);
            }


        });

    }

    public void home_screen_currency(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void retry_currency(View view){
        Intent intent = new Intent(this, currency_converter.class);
        startActivity(intent);
        finish();
    }


}
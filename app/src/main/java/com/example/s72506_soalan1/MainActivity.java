package com.example.s72506_soalan1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etBill;
    private RadioGroup radioGrouptipPercent;
    private Button btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize views
        etBill =  findViewById(R.id.etBill);
        radioGrouptipPercent = findViewById(R.id.radioGrouptipPercent);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });

    }

    private void calculateTip() {
        String billText = etBill.getText().toString().trim();

        if(billText.isEmpty()) {
            Toast.makeText(this, "Please enter bill amount", Toast.LENGTH_SHORT).show();
            return;
        }

        double billAmount = Double.parseDouble(billText);

        if (billAmount <= 0) {
            Toast.makeText(this, "Bill amount must be greater than 0", Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedId = radioGrouptipPercent.getCheckedRadioButtonId();

        if (selectedId == -1) {
            Toast.makeText(this, "Select tip percentage", Toast.LENGTH_SHORT).show();
            return;
        }

        double tipPercent = 0;
        RadioButton selectedRadio = findViewById(selectedId);
         if (selectedRadio.getText().toString().equals("5%")) {
             tipPercent = 5;
        } else if (selectedRadio.getText().toString().equals("10%")) {
             tipPercent = 10;
         }else if (selectedRadio.getText().toString().equals("15%")){
             tipPercent = 15;
         }

         double tip = billAmount * (tipPercent / 100);

         String result = String.format("Tip: RM%.2f", tip);

         textViewResult.setText(result);
    }

}
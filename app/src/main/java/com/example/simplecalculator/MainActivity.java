package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        result = findViewById(R.id.result);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());
                double res = 0;

                if (v.getId() == R.id.btnAdd) {
                    res = num1 + num2;
                } else if (v.getId() == R.id.btnSubtract) {
                    res = num1 - num2;
                } else if (v.getId() == R.id.btnMultiply) {
                    res = num1 * num2;
                } else if (v.getId() == R.id.btnDivide) {
                    if (num2 != 0)
                        res = num1 / num2;
                    else {
                        Toast.makeText(MainActivity.this, "Can't divide by 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                result.setText("Result: " + res);
            }
        };


        btnAdd.setOnClickListener(listener);
        btnSubtract.setOnClickListener(listener);
        btnMultiply.setOnClickListener(listener);
        btnDivide.setOnClickListener(listener);

    }
}

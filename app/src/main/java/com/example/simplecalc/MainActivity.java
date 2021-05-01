package com.example.simplecalc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editNum2;
    private EditText editNum1;
    private TextView textOut;
    private Calculator calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        textOut = findViewById(R.id.textOut);
        calc = new Calculator();
    }

    public void onAdd(View view) {
        compute(Calculator.Operator.ADD);
    }

    public void onSub(View view) {
        compute(Calculator.Operator.SUB);
    }

    public void onMul(View view) {
        compute(Calculator.Operator.MUL);
    }

    public void onDiv(View view) {
        compute(Calculator.Operator.DIV);
    }

    private void compute(Calculator.Operator operator) {
        if (editNum1.getText().toString().length() == 0 || editNum2.getText().toString().length() == 0) {
            Toast.makeText(this, "the numbers cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            double num1 = Double.parseDouble(editNum1.getText().toString());
            double num2 = Double.parseDouble(editNum2.getText().toString());
            double output;
            switch (operator) {
                case ADD:
                    output = calc.add(num1, num2);
                    textOut.setText(String.valueOf(output));
                    break;
                case SUB:
                    output = calc.sub(num1, num2);
                    textOut.setText(String.valueOf(output));
                    break;
                case MUL:
                    output = calc.mul(num1, num2);
                    textOut.setText(String.valueOf(output));
                    break;
                case DIV:
                    output = calc.div(num1, num2);
                    textOut.setText(String.valueOf(output));
                    break;
            }
        }

    }


}
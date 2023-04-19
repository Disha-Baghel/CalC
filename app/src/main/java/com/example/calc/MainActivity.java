package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    ListView listView1, listView2;
    TextView calc, result;
    String b00, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    String bMod, bDivide, bX, bMinus, bPlus, bPoint, bClear;
    Button btnAC, btnClear, btnMod, btnDivide, btnX, btnMinus, btnPlus, btnPoint, btnResult;
    Button btn00, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnFunctions();
    }

    private void init(){
        result = findViewById(R.id.result);
        btn00 = findViewById(R.id.btn00);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAC = findViewById(R.id.btnAC);
        btnClear = findViewById(R.id.btnClear);
        btnMod = findViewById(R.id.btnMod);
        btnDivide = findViewById(R.id.btnDivide);
        btnX = findViewById(R.id.btnX);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnPoint = findViewById(R.id.btnPoint);
        btnResult = findViewById(R.id.btnResult);
    }

    public void btnFunctions(){
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all_clear();
            }
        });
        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b00 = btn00.getText().toString();
                result.append(b00);
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b0 = btn0.getText().toString();
                result.append(b0);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1 = btn1.getText().toString();
                result.append(b1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2 = btn2.getText().toString();
                result.append(b2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3 = btn3.getText().toString();
                result.append(b3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4 = btn4.getText().toString();
                result.append(b4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5 = btn5.getText().toString();
                result.append(b5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b6 = btn6.getText().toString();
                result.append(b6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b7 = btn7.getText().toString();
                result.append(b7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b8 = btn8.getText().toString();
                result.append(b8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b9 = btn9.getText().toString();
                result.append(b9);
            }
        });
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bMod = btnMod.getText().toString();
                result.append(bMod);
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bDivide = btnDivide.getText().toString();
                result.append(bDivide);
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bX = btnX.getText().toString();
                result.append(bX);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bMinus = btnMinus.getText().toString();
                result.append(bMinus);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPlus = btnPlus.getText().toString();
                result.append(bPlus);
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPoint = btnPoint.getText().toString();
                result.append(bPoint);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().toString().length() == 0){
                    result.setText("");
                }
                else {
                    bClear = result.getText().toString().substring(0, result.getText().toString().length() - 1);
                    result.setText(bClear);
                }
            }
        });
    }

    public void all_clear(){
        result.setText("");
    }
}
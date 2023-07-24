package com.example.calc;

import static android.util.TypedValue.COMPLEX_UNIT_PX;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity{
    Operations operation = new Operations();
    Operations operations = new Operations();

    HorizontalScrollView horizontalScrollView;
    ListView listView1, listView2;
    TextView calc, result;
    EditText expression;
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

    @SuppressLint("ClickableViewAccessibility")
    private void init(){

        horizontalScrollView = findViewById(R.id.horizontalScrollView);
        expression = findViewById(R.id.expression);
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

        expression.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                horizontalScrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        horizontalScrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        expression.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inType = expression.getInputType();
                expression.setInputType(InputType.TYPE_NULL);
                expression.onTouchEvent(event);
                expression.setSelection(expression.getText().length());
                expression.setInputType(inType);
                return true;
            }
        });
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
                expression.append(b00);
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b0 = btn0.getText().toString();
                expression.append(b0);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1 = btn1.getText().toString();
                expression.append(b1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2 = btn2.getText().toString();
                expression.append(b2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3 = btn3.getText().toString();
                expression.append(b3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4 = btn4.getText().toString();
                expression.append(b4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5 = btn5.getText().toString();
                expression.append(b5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b6 = btn6.getText().toString();
                expression.append(b6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b7 = btn7.getText().toString();
                expression.append(b7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b8 = btn8.getText().toString();
                expression.append(b8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b9 = btn9.getText().toString();
                expression.append(b9);
            }
        });
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bMod = btnMod.getText().toString();
                expression.append(bMod);
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bDivide = btnDivide.getText().toString();
                expression.append(bDivide);
                //stack.push(Integer.parseInt(btn00.getText().toString()));
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bX = btnX.getText().toString();
                expression.append(bX);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bMinus = btnMinus.getText().toString();
                expression.append(bMinus);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPlus = btnPlus.getText().toString();
                expression.append(bPlus);
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPoint = btnPoint.getText().toString();
                expression.append(bPoint);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expression.getText().toString().length() == 0){
                    expression.setText("");
                }
                else {
                    bClear =expression.getText().toString().substring(0, expression.getText().toString().length() - 1);
                    expression.setText(bClear);
                }
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result();
            }
        });
    }

    public void all_clear(){
        expression.setText("");
        expression.setTextSize(50);
    }

    public void result() {
        String input = expression.getText().toString();
        Tokenizer tokenizer = new Tokenizer(input);

        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<Token> tokenList = tokenizer.tokenize();

        for (Token token: tokenList) {
            if (token.isEOF() || token.isInvalid())
                return;
            switch (token.type) {
                case TOKEN_ADD: stringBuilder.append("+");
                    break;
                case TOKEN_SUBTRACT: stringBuilder.append("-");
                    break;
                case TOKEN_MULTIPLY: stringBuilder.append("*");
                    break;
                case TOKEN_DIVIDE: stringBuilder.append("/");
                    break;
                case TOKEN_EXPONENT: stringBuilder.append("^");
                    break;
            }
        }

        Log.d("Hello", stringBuilder.toString());
        // stacks.infix_to_postfix(expression.getText().toString());
    }
}
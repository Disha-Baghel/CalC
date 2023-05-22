package com.example.calc;

import java.util.Stack;

public class Stacks {

    Stack<Character> stack = new Stack<Character>();

    public int precedence (char symbol) {

        switch (symbol) {

            case '+' :
            case '-' : return 1;
            case '/' :
            case '*' : return 2;
            case '^' : return 3;
            default : return -1;

        }
    }

    public void infix_to_postfix(String expression) {

        String finalExpression = "";

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            int precedence = precedence(symbol);

            if(precedence == -1) {
                finalExpression = finalExpression + symbol;
            }
        }
    }

}

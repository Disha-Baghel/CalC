package com.example.calc;

import java.util.Stack;

public class Stacks {

    Stack<Character> stack = new Stack<Character>();

    public int precedence (char symbol) {

        switch (symbol) {

            case '(' : return 0;
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
        stack.push('(');

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if(symbol >= 48 && symbol <= 57) {
                finalExpression = finalExpression + symbol;
            }

            else if(symbol == '(' || symbol == '+' || symbol == '-' || symbol == '/' || symbol == 'X' || symbol == '^') {
                int precedence = precedence(symbol);

                if (precedence > precedence(stack.peek())) {
                    stack.push(symbol);
                }
                else {
                    while (precedence < precedence(stack.peek())) {
                        finalExpression = finalExpression + stack.pop();
                        precedence = precedence(stack.peek());
                    }
                }
            }


        }
    }

}

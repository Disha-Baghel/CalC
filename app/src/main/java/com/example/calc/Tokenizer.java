package com.example.calc;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.lang.Character;

public class Tokenizer {

    private int currentTokenIndex = 0;
    private int index = 0;

    private String input;

    public Tokenizer(String input) {
        this.input = input;
    }

    private char peek() {
        return input.charAt(index);
    }

    private void advance() {
        if (index < input.length())
            ++index;
    }

    private boolean isOperand(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    public ArrayList<Token> tokenize () {

        ArrayList<Token> tokenList = new ArrayList<>();

        while(index < input.length()) {
            char ch = input.charAt(index);
            Token token = new Token(0, Token.TokenType.TOKEN_INVALID);
            if (Character.isDigit(ch)) {
                token = extractDigit(index);
            } else if (isOperand(ch)) {
                token = extractOperand(ch);
            }
            tokenList.add(token);
            ++index;
        }

        tokenList.add(new Token(0, Token.TokenType.TOKEN_EOF));
        return tokenList;
    }

    private Token extractOperand(char ch) {
        switch (ch) {
            case '+': return new Token(0, Token.TokenType.TOKEN_ADD);
            case '-': return new Token(0, Token.TokenType.TOKEN_SUBTRACT);
            case '/': return new Token(0, Token.TokenType.TOKEN_DIVIDE);
            case '*': return new Token(0, Token.TokenType.TOKEN_MULTIPLY);
            case '^': return new Token(0, Token.TokenType.TOKEN_EXPONENT);
        }
        return new Token(-1, Token.TokenType.TOKEN_INVALID);
    }

    private Token extractDigit(int index) {
        int start = index;

        while (Character.isDigit(input.charAt(index))){
            ++index;
        }
        if (peek() == '.') {
            ++index;
        }
        while (Character.isDigit(input.charAt(index))) {
            ++index;
        }
        --index;
        double number = Integer.parseInt(input.substring(start, index));
        return new Token(number, Token.TokenType.TOKEN_OPERAND);
    }

}

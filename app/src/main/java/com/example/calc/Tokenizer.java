package com.example.calc;

import java.util.ArrayList;
import java.util.List;
import java.lang.Character;

public class Tokenizer {

    private ArrayList<Token> tokenList;

    private int currentTokenIndex = 0;
    private int index = 0;

    public Tokenizer(String input) {
        tokenList = tokenize(input);
    }

    public Token peek() {
        return tokenList.get(currentTokenIndex);
    }

    public void advance() {
        if (!peek().isEOF()) {
            currentTokenIndex += 1;
        }
    }

    public  Token nextToken() {
        advance();
        return peek();
    }

    private boolean isOperand(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    private ArrayList<Token> tokenize(String input) {

        ArrayList<Token> tokenList = new ArrayList<>();

        while(index < input.length()) {
            char ch = input.charAt(index);
            Token token = new Token(0, Token.TokenType.TOKEN_INVALID);
            if(Character.isDigit(ch)) {
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

    }

}

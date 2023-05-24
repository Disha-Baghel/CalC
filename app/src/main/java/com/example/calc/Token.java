package com.example.calc;

public class Token {

    public double operand;

    public enum TokenType {
        TOKEN_OPERAND,

        TOKEN_ADD,
        TOKEN_SUBTRACT,
        TOKEN_MULTIPLY,
        TOKEN_DIVIDE,
        TOKEN_EXPONENT,

        TOKEN_INVALID,
        TOKEN_EOF
    }

    public TokenType type;

    Token(double operand, TokenType type) {
        this.operand = operand;
        this.type = type;
    }

    public boolean isOperand() {
        return type == TokenType.TOKEN_OPERAND;
    }

    public boolean isEOF() {
        return type == TokenType.TOKEN_EOF;
    }

    public boolean isInvalid() {
        return type == TokenType.TOKEN_INVALID;
    }

}
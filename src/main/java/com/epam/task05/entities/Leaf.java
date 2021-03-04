package com.epam.task05.entities;

import com.epam.task05.logic.interpreter.ExpressionCalculator;

public class Leaf implements Component {
    private String token;
    private TokenType type;

    public Leaf(String token, TokenType type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public TokenType getType() {
        return type;
    }

    @Override
    public String toString() {
        if (this.type == TokenType.EXPRESSION) {
            ExpressionCalculator calculator = new ExpressionCalculator(this.token);
            int calculated = calculator.calculate();
            return String.valueOf(calculated);
        } else {
            return this.token;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) object;
        return token.equals(leaf.token) && type == leaf.type;
    }

    @Override
    public int hashCode() {
        return token.hashCode() + type.hashCode();
    }
}
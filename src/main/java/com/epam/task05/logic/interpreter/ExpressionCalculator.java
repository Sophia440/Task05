package com.epam.task05.logic.interpreter;

import com.epam.task05.parser.ExpressionParser;

import java.util.List;

public class ExpressionCalculator {
    private List<AbstractExpressionPart> expressionParts;
    private ExpressionParser parser;

    public ExpressionCalculator(String expression) {
        this.parser = new ExpressionParser();
        this.expressionParts = parser.parse(expression);
    }

    public int calculate() {
        Context context = new Context();
        for (AbstractExpressionPart part : expressionParts) {
            part.interpret(context);
        }
        return context.popValue();
    }
}


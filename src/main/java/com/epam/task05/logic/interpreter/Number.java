package com.epam.task05.logic.interpreter;

public class Number extends AbstractExpressionPart {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}

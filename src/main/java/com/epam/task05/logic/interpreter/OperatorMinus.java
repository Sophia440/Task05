package com.epam.task05.logic.interpreter;

public class OperatorMinus extends AbstractExpressionPart {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() - context.popValue());
    }
}

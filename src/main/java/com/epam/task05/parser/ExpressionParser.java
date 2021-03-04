package com.epam.task05.parser;

import com.epam.task05.logic.interpreter.*;
import com.epam.task05.logic.interpreter.Number;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {
    private static final String SPLITTER = "\\p{Blank}+";
    private static final String REGEXP_INTEGER = "\\d+";
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLIER = '*';
    private static final char DIVIDER = '/';

    public List<AbstractExpressionPart> parse(String expression) {
        List<AbstractExpressionPart> expressionParts = new ArrayList<>();
        for (String part : expression.split(SPLITTER)) {
            if (part.isEmpty()) {
                continue;
            }
            char firstCharacter = part.charAt(0);
            switch (firstCharacter) {
                case PLUS:
                    expressionParts.add(new OperatorPlus());
                    break;
                case MINUS:
                    expressionParts.add(new OperatorMinus());
                    break;
                case MULTIPLIER:
                    expressionParts.add(new OperatorMultiplier());
                    break;
                case DIVIDER:
                    expressionParts.add(new OperatorDivider());
                    break;
                default:
                    if (part.matches(REGEXP_INTEGER)) {
                        expressionParts.add(new Number(Integer.parseInt(part)));
                    }
            }
        }
        return expressionParts;
    }
}


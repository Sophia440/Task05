package com.epam.task05.parser;

import com.epam.task05.entities.Component;
import com.epam.task05.entities.Composite;
import com.epam.task05.entities.Leaf;
import com.epam.task05.entities.TokenType;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    private static final String SPLITTER_BRACKETS = "[\\[\\]]";
    private static final String SPLITTER_SPACE = " ";
    private static final String EMPTY_TOKEN = "";
    private static final String REGEXP_MATH_EXPRESSION = "(\\d+[ .])+([ +/*-])+";

    public SentenceParser(Parser successor) {
        super(successor);
    }

    public Component parse(String input) {

        Pattern patternBrackets = Pattern.compile(SPLITTER_BRACKETS);
        String[] tokens = patternBrackets.split(input);

        Composite sentence = new Composite();
        Arrays.stream(tokens).forEach(token -> {
                    if (!token.equals(EMPTY_TOKEN)) {
                        if (token.matches(REGEXP_MATH_EXPRESSION)) {
                            Leaf expression = new Leaf(token, TokenType.EXPRESSION);
                            sentence.add(expression);
                        } else {
                            String[] words = token.split(SPLITTER_SPACE);
                            Arrays.stream(words).forEach(word -> {
                                if (!word.equals(EMPTY_TOKEN)) {
                                    Leaf wordLeaf = new Leaf(word, TokenType.WORD);
                                    sentence.add(wordLeaf);
                                }
                            });
                        }
                    }
                }
        );
        return sentence;
    }
}

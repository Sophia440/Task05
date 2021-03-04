package com.epam.task05.parser;

import com.epam.task05.entities.Composite;
import com.epam.task05.entities.Leaf;
import com.epam.task05.entities.TokenType;

import java.util.Arrays;

public interface ParserTest {
    String FIRST_PARAGRAPH_STRING = "text [5 6 15 + *].";
    String SECOND_PARAGRAPH_STRING = "[1 2 3 + *] text1.";

    String FIRST_SENTENCE_STRING = "text [5 6 15 + *]";
    String SECOND_SENTENCE_STRING = "[1 2 3 + *] text1";

    Leaf FIRST_WORD = new Leaf("text", TokenType.WORD);
    Leaf FIRST_EXPRESSION = new Leaf("5 6 15 + *", TokenType.EXPRESSION);
    Leaf SECOND_EXPRESSION = new Leaf("1 2 3 + *", TokenType.EXPRESSION);
    Leaf SECOND_WORD = new Leaf("text1", TokenType.WORD);

    Composite FIRST_SENTENCE_COMPOSITE = new Composite(Arrays.asList(FIRST_WORD,
            FIRST_EXPRESSION));
    Composite SECOND_SENTENCE_COMPOSITE = new Composite(Arrays.asList(SECOND_EXPRESSION,
            SECOND_WORD));
}

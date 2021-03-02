package com.epam.task05.parser;

import com.epam.task05.entities.Component;
import com.epam.task05.entities.Composite;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceParserTest implements ParserTest {
    private static final SentenceParser PARSER = new SentenceParser(null);
    private static final String INPUT = "text [5 6 15 + *] [1 2 3 + *] text1";
    private static final Composite EXPECTED = new Composite(Arrays.asList(FIRST_WORD, FIRST_EXPRESSION,
            SECOND_EXPRESSION, SECOND_WORD));

    @Test
    public void testParseWithProvidedInputShouldSucceed() {
        Component actual = PARSER.parse(INPUT);
        Assert.assertEquals(EXPECTED, actual);
    }
}

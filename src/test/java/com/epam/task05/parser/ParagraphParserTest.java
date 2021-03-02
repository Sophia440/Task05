package com.epam.task05.parser;

import com.epam.task05.entities.Component;
import com.epam.task05.entities.Composite;
import com.epam.task05.entities.Leaf;
import com.epam.task05.entities.TokenType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class ParagraphParserTest implements ParserTest {
    private static final SentenceParser SENTENCE_PARSER = Mockito.mock(SentenceParser.class);
    private static final ParagraphParser PARAGRAPH_PARSER = new ParagraphParser(SENTENCE_PARSER);

    private static final String INPUT = "text [5 6 15 + *]. [1 2 3 + *] text1.";
    private static final Composite EXPECTED = new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE,
            SECOND_SENTENCE_COMPOSITE));

    @Test
    public void testParseWithProvidedInputShouldSucceed() {
        when(SENTENCE_PARSER.parse(FIRST_SENTENCE_STRING)).thenReturn(FIRST_SENTENCE_COMPOSITE);
        when(SENTENCE_PARSER.parse(SECOND_SENTENCE_STRING)).thenReturn(SECOND_SENTENCE_COMPOSITE);

        Component actual = PARAGRAPH_PARSER.parse(INPUT);
        Assert.assertEquals(EXPECTED, actual);

        verify(SENTENCE_PARSER, times(1)).parse(FIRST_SENTENCE_STRING);
        verify(SENTENCE_PARSER, times(1)).parse(FIRST_SENTENCE_STRING);
    }
}

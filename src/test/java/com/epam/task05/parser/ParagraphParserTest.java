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
    private final SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
    private final ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);

    private static final String INPUT = "text [5 6 15 + *]. [1 2 3 + *] text1.";
    private static final Composite EXPECTED = new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE,
            SECOND_SENTENCE_COMPOSITE));

    @Test
    public void testParseWithProvidedInputShouldSucceed() {
        when(sentenceParser.parse(FIRST_SENTENCE_STRING)).thenReturn(FIRST_SENTENCE_COMPOSITE);
        when(sentenceParser.parse(SECOND_SENTENCE_STRING)).thenReturn(SECOND_SENTENCE_COMPOSITE);

        Component actual = paragraphParser.parse(INPUT);
        Assert.assertEquals(EXPECTED, actual);

        verify(sentenceParser, times(1)).parse(FIRST_SENTENCE_STRING);
        verify(sentenceParser, times(1)).parse(FIRST_SENTENCE_STRING);
    }
}

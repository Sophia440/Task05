package com.epam.task05.parser;

import com.epam.task05.entities.Component;
import com.epam.task05.entities.Composite;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class TextParserTest implements ParserTest {
    private static final ParagraphParser PARAGRAPH_PARSER = Mockito.mock(ParagraphParser.class);
    private static final TextParser TEXT_PARSER = new TextParser(PARAGRAPH_PARSER);

    private static final String INPUT = "text [5 6 15 + *].\n [1 2 3 + *] text1.";
    private static final Composite EXPECTED = new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE,
            SECOND_SENTENCE_COMPOSITE));

    @Test
    public void testParseWithProvidedInputShouldSucceed() {
        when(PARAGRAPH_PARSER.parse(FIRST_PARAGRAPH_STRING)).thenReturn(FIRST_SENTENCE_COMPOSITE);
        when(PARAGRAPH_PARSER.parse(SECOND_PARAGRAPH_STRING)).thenReturn(SECOND_SENTENCE_COMPOSITE);

        Component actual = TEXT_PARSER.parse(INPUT);
        Assert.assertEquals(EXPECTED, actual);

        verify(PARAGRAPH_PARSER, times(1)).parse(FIRST_PARAGRAPH_STRING);
        verify(PARAGRAPH_PARSER, times(1)).parse(FIRST_PARAGRAPH_STRING);
    }

}

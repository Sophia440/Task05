package com.epam.task05.logic;

import com.epam.task05.entities.Component;
import com.epam.task05.entities.Composite;
import com.epam.task05.entities.Leaf;
import com.epam.task05.entities.TokenType;
import com.epam.task05.reader.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TextLogicTest {
    private static final TextLogic TEXT_LOGIC = new TextLogic();

    private static final Leaf FIRST_LEAF = new Leaf("first", TokenType.WORD);
    private static final Leaf SECOND_LEAF = new Leaf("second", TokenType.WORD);
    private static final Leaf THIRD_LEAF = new Leaf("third", TokenType.WORD);
    private static final Leaf FIRST_EXPRESSION = new Leaf("2 3 +", TokenType.EXPRESSION);

    private static final Composite FIRST_SENTENCE = new Composite(Arrays.asList(SECOND_LEAF, FIRST_LEAF));
    private static final Composite SECOND_SENTENCE = new Composite(Arrays.asList(THIRD_LEAF, FIRST_EXPRESSION));

    private static final Composite FIRST_PARAGRAPH = new Composite(Arrays.asList(FIRST_SENTENCE));
    private static final Composite SECOND_PARAGRAPH = new Composite(Arrays.asList(SECOND_SENTENCE));
    private static final Composite THIRD_PARAGRAPH = new Composite(Arrays.asList(FIRST_SENTENCE, SECOND_SENTENCE));

    private static final Composite FIRST_TEXT = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH));
    private static final Composite SECOND_TEXT = new Composite(Arrays.asList(THIRD_PARAGRAPH, SECOND_PARAGRAPH));

    private static final Composite FIRST_SORTED = new Composite(Arrays.asList(SECOND_PARAGRAPH, THIRD_PARAGRAPH));

    private static final String EXPECTED_STRING = "first second third 5";
    private static final String FILE_PATH = "./src/test/resources/input_for_logic.txt";

    @Test
    public void testParseIntoComponents() throws DataException {
        Component actual = TEXT_LOGIC.parseIntoComponents(FILE_PATH);
        Assert.assertEquals(FIRST_TEXT, actual);
    }

    @Test
    public void testComposeIntoString() {
        String actual = TEXT_LOGIC.composeIntoString(FIRST_TEXT);
        Assert.assertEquals(EXPECTED_STRING, actual);
    }

    @Test
    public void testSortParagraphsBySentenceCount() {
        Component actual = TEXT_LOGIC.sortParagraphsBySentenceCount(SECOND_TEXT);
        Assert.assertEquals(FIRST_SORTED, actual);
    }

    @Test
    public void testSortWordsByLength() {
        Component actual = TEXT_LOGIC.sortWordsByLength(SECOND_TEXT);
        Assert.assertEquals(FIRST_SORTED, actual);
    }

    @Test
    public void testSortTokensBySymbolCount() {

    }
}

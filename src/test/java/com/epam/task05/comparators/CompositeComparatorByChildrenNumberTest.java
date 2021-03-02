package com.epam.task05.comparators;

import com.epam.task05.entities.Composite;
import com.epam.task05.entities.Leaf;
import com.epam.task05.entities.TokenType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CompositeComparatorByChildrenNumberTest {
    private static final Leaf FIRST_LEAF = new Leaf("first", TokenType.WORD);
    private static final Leaf SECOND_LEAF = new Leaf("second", TokenType.WORD);
    private static final Leaf THIRD_LEAF = new Leaf("third", TokenType.WORD);
    private static final Composite FIRST_SENTENCE = new Composite(Arrays.asList(FIRST_LEAF, SECOND_LEAF));
    private static final Composite SECOND_SENTENCE = new Composite(Arrays.asList(THIRD_LEAF));

    @Test
    public void testCompareWithValidInputShouldSucceed() {
        CompositeComparatorByChildrenNumber comparator = new CompositeComparatorByChildrenNumber();
        int actual = comparator.compare(FIRST_SENTENCE, SECOND_SENTENCE);
        Assert.assertEquals(1, actual);
    }
}

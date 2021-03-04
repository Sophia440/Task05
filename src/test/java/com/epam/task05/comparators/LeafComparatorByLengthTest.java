package com.epam.task05.comparators;

import com.epam.task05.entities.Leaf;
import com.epam.task05.entities.TokenType;
import org.junit.Assert;
import org.junit.Test;

public class LeafComparatorByLengthTest {
    private static final Leaf FIRST_LEAF = new Leaf("first", TokenType.WORD);
    private static final Leaf SECOND_LEAF = new Leaf("second", TokenType.WORD);

    @Test
    public void testCompareWithValidInputShouldSucceed() {
        LeafComparatorByLength comparator = new LeafComparatorByLength();
        int actual = comparator.compare(SECOND_LEAF, FIRST_LEAF);
        Assert.assertEquals(1, actual);
    }
}

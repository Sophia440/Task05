package com.epam.task05.comparators;

import org.junit.Assert;
import org.junit.Test;

public class StringComparatorByGivenCharCountTest {
    private static final char CHARACTER = 'k';
    private final StringComparatorByGivenCharCount comparator = new StringComparatorByGivenCharCount(CHARACTER);
    private static final String FIRST_STRING = "kk";
    private static final String SECOND_STRING = "bk";
    private static final String THIRD_STRING = "ak";

    @Test
    public void testCompareWithValidInputShouldSucceed() {
        int actual = comparator.compare(SECOND_STRING, FIRST_STRING);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void testCompareWithEqualNumberOfCharactersShouldSucceed() {
        int actual = comparator.compare(SECOND_STRING, THIRD_STRING);
        Assert.assertEquals(1, actual);
    }
}
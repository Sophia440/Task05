package com.epam.task05.reader;

import org.junit.Assert;
import org.junit.Test;

public class DataReaderTest {
    private static final DataReader DATA_READER = new DataReader();
    private static final String PATH_INPUT_FILE = "./src/test/resources/input.txt";
    private static final String PATH_NONEXISTENT_FILE = "./src/test/resources/input1.txt";
    private static final String EXPECTED = "some text 1\nsome text 2\nsome text 3";

    @Test
    public void testReadDataWithValidPathShouldSucceed() throws DataException {
        String actual = DATA_READER.readData(PATH_INPUT_FILE);
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test(expected = DataException.class)
    public void testReadDataWithNonexistentFileShouldThrowException() throws DataException {
        String actual = DATA_READER.readData(PATH_NONEXISTENT_FILE);
        Assert.assertEquals(EXPECTED, actual);
    }
}

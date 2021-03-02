package com.epam.task05.reader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class DataReader {
    private static final String LINE_DELIMITER = "\n";
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public String readData(String filename) throws DataException {
        StringJoiner joiner = new StringJoiner(LINE_DELIMITER);
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(filename), StandardCharsets.UTF_8);
            lines.forEach(joiner::add);
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        } finally {
            if (lines != null) {
                try {
                    lines.close();
                } catch (NullPointerException e) {
                    LOGGER.warn(e.getMessage(), e);
                }
            }
        }
        return joiner.toString();
    }

}

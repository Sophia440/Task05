package com.epam.task05.parser;

import com.epam.task05.entities.Component;
import com.epam.task05.entities.Composite;

import java.util.Arrays;

public class ParagraphParser extends AbstractParser {
    private static final String SPLITTER = "[.?!]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String input) {

        String[] sentences = input.split(SPLITTER);

        Composite paragraph = new Composite();
        Arrays.stream(sentences).forEach(sentence -> {
                    Component component = getSuccessor().parse(sentence.trim());
                    paragraph.add(component);
                }
        );
        return paragraph;
    }
}

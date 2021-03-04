package com.epam.task05.parser;

import com.epam.task05.entities.Component;
import com.epam.task05.entities.Composite;

import java.util.Arrays;

public class TextParser extends AbstractParser {
    private static final String SPLITTER = "\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    public Component parse(String input) {

        String[] paragraphs = input.split(SPLITTER);

        Composite text = new Composite();
        Arrays.stream(paragraphs).forEach(paragraph -> {
                    Component component = getSuccessor().parse(paragraph.trim());
                    text.add(component);
                }
        );
        return text;
    }
}

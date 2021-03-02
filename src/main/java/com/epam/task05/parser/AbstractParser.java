package com.epam.task05.parser;

import com.epam.task05.entities.Component;

public class AbstractParser implements Parser {
    private Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    @Override
    public Component parse(String text) {
        return null;
    }
}

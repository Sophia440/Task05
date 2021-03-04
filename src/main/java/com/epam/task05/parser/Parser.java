package com.epam.task05.parser;

import com.epam.task05.entities.Component;

public interface Parser {
    Component parse(String text);
}

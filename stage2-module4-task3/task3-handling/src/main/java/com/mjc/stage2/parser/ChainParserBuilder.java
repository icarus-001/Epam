package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        AbstractTextParser firstParser = parsers.get(0);
        AbstractTextParser previousParser = firstParser;

        for (int i = 1; i < parsers.size(); i++) {
            AbstractTextParser currentParser = parsers.get(i);
            previousParser.setNextParser(currentParser);
            previousParser = currentParser;
        }

        return firstParser;
    }
}

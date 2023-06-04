package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser {

    private static final Pattern LEXEME_PATTERN = Pattern.compile("\\p{Punct}|\\s");

    @Override
    public void parse(AbstractTextComponent textComponent, String string) {
        Matcher matcher = LEXEME_PATTERN.matcher(string);
        while (matcher.find()) {
            char symbol = matcher.group().charAt(0);
            AbstractTextComponent symbolComponent = new SymbolLeaf(symbol);
            textComponent.add(symbolComponent);
        }
        if (nextParser != null) {
            nextParser.parse(textComponent, string);
        }
    }
}

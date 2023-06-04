package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractTextParser {

    private static final Pattern WORD_PATTERN = Pattern.compile("[\\p{L}\\p{N}]+");

    @Override
    public void parse(AbstractTextComponent textComponent, String string) {
        Matcher matcher = WORD_PATTERN.matcher(string);
        while (matcher.find()) {
            String word = matcher.group();
            AbstractTextComponent wordComponent = new TextComponent(TextComponentType.WORD);
            for (char symbol : word.toCharArray()) {
                AbstractTextComponent symbolComponent = new SymbolLeaf(symbol);
                wordComponent.add(symbolComponent);
            }
            textComponent.add(wordComponent);
        }
        if (nextParser != null) {
            nextParser.parse(textComponent, string);
        }
    }
}

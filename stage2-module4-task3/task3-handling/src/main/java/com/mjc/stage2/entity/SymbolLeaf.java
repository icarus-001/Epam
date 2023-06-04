package com.mjc.stage2.entity;

public class SymbolLeaf extends AbstractTextComponent {
    private char symbol;

    public SymbolLeaf(char symbol) {
        super(TextComponentType.SYMBOL);
        this.symbol = symbol;
    }

    @Override
    public String operation() {
        return String.valueOf(symbol);
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException("Can't add component to symbol");
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException("Can't remove component from symbol");
    }

    @Override
    public int getSize() {
        return 1;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
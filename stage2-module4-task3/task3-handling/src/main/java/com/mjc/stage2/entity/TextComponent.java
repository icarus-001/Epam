package com.mjc.stage2.entity;


import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    private List<AbstractTextComponent> components = new ArrayList<>();

    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        StringBuilder builder = new StringBuilder();
        for (AbstractTextComponent component : components) {
            builder.append(component.operation());
        }
        return builder.toString();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        components.add(textComponent);
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        components.remove(textComponent);
    }

    @Override
    public int getSize() {
        int size = 0;
        for (AbstractTextComponent component : components) {
            size += component.getSize();
        }
        return size;
    }
}
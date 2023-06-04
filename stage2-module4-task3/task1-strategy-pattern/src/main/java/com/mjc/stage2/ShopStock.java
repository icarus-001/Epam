package com.mjc.stage2;

import java.util.List;
import java.util.stream.Collectors;

public class ShopStock {

    private List<Product> products;

    public ShopStock(List<Product> products) {
        this.products = products;
    }

    public List<Product> executeFilteringStrategy(FilteringStrategy filteringStrategy) {
        return products.stream()
                .filter(filteringStrategy::filter)
                .collect(Collectors.toList());
    }

}

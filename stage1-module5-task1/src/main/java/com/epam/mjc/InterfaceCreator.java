package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x) {
                if (!(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')) {
                    return false;
                }
            }
            return true;

        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>();
            for (Integer n : x) {
                if ((n % 2) == 0) {
                    list.add(n);
                }
            }
            x.addAll(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String string : values) {
                if (string.charAt(0) >= 'A' && string.charAt(0) <= 'Z') {
                    if (string.charAt(string.length() - 1) == '.') {
                        String[] strings = string.split(" ");
                        if (strings.length > 3) {

                        } else list.add(string);
                    } else list.add(string);
                } else list.add(string);
            }
            values.removeAll(list);
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String string : x) {
                map.put(string, string.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {

            List<Integer> list =  new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };


    }
}

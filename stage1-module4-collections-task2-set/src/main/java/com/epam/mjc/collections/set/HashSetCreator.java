package com.epam.mjc.collections.set;

import java.util.HashSet;
import java.util.List;

public class HashSetCreator {
    public HashSet<Integer> createHashSet(List<Integer> sourceList) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer list : sourceList) {
            if (list % 2 == 0) {
                while (list % 2 == 0) {
                    hashSet.add(list);
                    list /= 2;
                } hashSet.add(list);
            } else {
                hashSet.add(list);
                hashSet.add(2*list);
            }
        }
        return  hashSet;
    }
}

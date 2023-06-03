package com.epam.mjc.collections.set;

import java.util.HashSet;
import java.util.Set;

public class SetCombinationCreator {
    public Set<String> createSetCombination(Set<String> firstSet, Set<String> secondSet, Set<String> thirdSet) {
        Set<String> result = new HashSet<>();
        for (String string : firstSet) {
            if (secondSet.contains(string) && !thirdSet.contains(string)) {
                result.add(string);
            }
        }

        for (String string : thirdSet) {
            if (!(firstSet.contains(string) || secondSet.contains(string))) {
                result.add(string);
            }
        }

        return result;
    }
}

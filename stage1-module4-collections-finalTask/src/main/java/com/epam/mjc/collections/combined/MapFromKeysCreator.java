package com.epam.mjc.collections.combined;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> setMap = new HashMap<>();
        for (String key : sourceMap.keySet()) {
            if (setMap.containsKey(key.length())) {
                setMap.get(key.length()).add(key);
            } else {
                Set<String> hashSet = new HashSet<>();
                hashSet.add(key);
                setMap.put(key.length(), hashSet);
            }
        }
        return setMap;
    }
}

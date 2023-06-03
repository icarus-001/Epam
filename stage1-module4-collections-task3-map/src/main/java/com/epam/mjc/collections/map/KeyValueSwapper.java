package com.epam.mjc.collections.map;

import java.util.HashMap;
import java.util.Map;

public class KeyValueSwapper {
    public Map<String, Integer> swap(Map<Integer, String> sourceMap) {
        Map<String, Integer> map = new HashMap<>();
        for (Integer key : sourceMap.keySet()) {
            if (map.containsKey(sourceMap.get(key))) {
                if (key < map.get(sourceMap.get(key))) {
                    map.put(sourceMap.get(key), key);
                }
            }
            map.put(sourceMap.get(key),key);
        }
        return map;
    }
}

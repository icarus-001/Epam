package com.epam.mjc.collections.map;

import java.util.HashMap;
import java.util.Map;

public class WordRepetitionMapCreator {
    public Map<String, Integer> createWordRepetitionMap(String sentence) {
        sentence = sentence.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        String[] words = sentence.split("[\\s!?.,]");

        for (String word : words) {
            word = word.trim();
            if(word.equals("")) {
                continue;
            }
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word,1);
            }
        }

        return map;
    }
}

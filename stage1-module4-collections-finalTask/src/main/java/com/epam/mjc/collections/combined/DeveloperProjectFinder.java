package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> list = new ArrayList<>();
        for (String key : projects.keySet()) {
            if (projects.get(key).contains(developer)) {
                list.add(key);
            }
        }

        return list;
    }
}

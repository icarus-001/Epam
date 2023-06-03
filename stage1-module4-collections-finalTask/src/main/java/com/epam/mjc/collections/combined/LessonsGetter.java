package com.epam.mjc.collections.combined;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LessonsGetter {
    public Set<String> getLessons(Map<String, List<String>> timetable) {
        Set<String> mySet = new HashSet<>();
        for (String key : timetable.keySet()) {
            mySet.addAll(timetable.get(key));
        }
        return mySet;
    }
}

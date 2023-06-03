package com.epam.mjc.collections.list;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorter {
    public void sort(List<String> sourceList) {
        ListComparator myComparator = new ListComparator();
        Collections.sort(sourceList, myComparator);
    }
}

class ListComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        int first = Integer.parseInt(a);
        int second = Integer.parseInt(b);
        if (5 * Math.pow(first,2) > 5 * Math.pow(second,2)) {
            return 1;
        } else if (5 * Math.pow(first,2) < 5 * Math.pow(second,2)) {
            return -1;
        } else if (first > second) {
            return 1;
        } else {
            return -1;
        }
    }
}

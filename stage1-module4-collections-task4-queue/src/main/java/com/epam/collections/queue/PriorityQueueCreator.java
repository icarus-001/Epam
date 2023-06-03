package com.epam.collections.queue;


import java.util.*;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {

        List<String> myList = new ArrayList<>(firstList);
        myList.addAll(secondList);
        Comparator<String> comparator = (o1, o2) -> {
            int size = Math.min(o1.length(), o2.length());
            for (int i = 0; i < size; i++) {
                if (o1.charAt(i) < o2.charAt(i)) {
                    return 1;
                } else if (o1.charAt(i) > o2.charAt(i)){
                    return -1;
                }
            }
            if (o1.length() >= o2.length()) {
                return 1;
            } else {
                return -1;
            }
        };
        myList.sort(comparator);
        Stack<String> myStack = new Stack<>();
        for (String s : myList) {
            myStack.push(s);
        }
        System.out.println(myList.size());
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(comparator);
        priorityQueue.addAll(myStack);


        return priorityQueue;
    }
}

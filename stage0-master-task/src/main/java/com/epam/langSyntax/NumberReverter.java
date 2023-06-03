package com.epam.langSyntax;

public class NumberReverter {

//    Revert 3-digit number that will be passed (e.g.: given -> 489, expected -> 984) and print it.
//    Where number - variable that should be used within the program.

    public void revert(int number) {
        int n = number % 10 * 100 + (number/10)%10 * 10 + (number/100) % 10;
        System.out.println(n);
    }

}

package com.epam.langSyntax;

public class DigitsSumCalculator {

//    You will be given a four-digit number your task will be to find the sum of all digits in the given number.
//    Where number - variable that should be used within the program.

    public static void calculateSum(int number) {
        int i = 0;
        while (number != 0) {
            i += number % 10;
            number /= 10;
        }
        System.out.println(i);
    }

}

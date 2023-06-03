package com.epam.loops;

import java.util.ArrayList;

public class Pyramid {

    public void printPyramid(int cathetusLength) {
        if (cathetusLength == 0) {
            return;
        }

        int num = 1;
        String numString = "";
        String emptyString = "";
        String result;
        for (int j = 0; j < cathetusLength; j++) {
            for (int i = cathetusLength - j - 1; i > 0; i--) {
                emptyString += " ";
            }
            if (num == 1) {
                numString = num + numString;
            } else {
                numString = num + numString + num;
            }
            num++;
            result = emptyString + numString;
            emptyString = "";
            System.out.println(result);
        }



    }




    public static void main(String[] args) {
        new Pyramid().printPyramid(7);
    }

}

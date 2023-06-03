package com.epam.loops;

public class HalfPyramid {

    public void printHalfPyramid(int cathetusLength) {

        String emptyString = "";
        String asteriksString = "";
        String result = "";
        for (int i = 0; i < cathetusLength; i++) {
            for (int j = cathetusLength - i - 1; j > 0; j--) {
                emptyString += " ";
            }
            asteriksString += "*";
            result = emptyString + asteriksString;
            emptyString = "";
            System.out.println(result);

        }

    }

    public static void main(String[] args) {
        new HalfPyramid().printHalfPyramid(8);
    }

}

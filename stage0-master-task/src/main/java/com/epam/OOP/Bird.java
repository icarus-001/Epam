package com.epam.OOP;
//  Task 2
//        Work with classes Dog and Bird. Extend them with the help of Animal.
//        Create no-args constructor for each where provide all necessary information for
//        Animal constructor by super() method:
//        for Dog: color - brown, numberOfPaws - 4, hasFur - true;
//        for Bird: color - blue, numberOfPaws - 2, hasFur - false.
//        Override getDescription() method for class Bird: add one more sentence to the description.
//        The result must be " This animal is mostly blue. It has 2 paws and no fur. Moreover, it has 2 wings and can fly."
//        (Optional) Create an object of each class and call getDescription() method for both of them. Try to explain the
//        output results.

public class Bird extends Animal{

    public Bird() {
        super("blue", 2, false);
    }
    @Override
    public String getDescription() {
       return ("This animal is mostly blue. It has 2 paws and no fur. Moreover, it has 2 wings and can fly.");
    }
}

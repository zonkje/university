package com.company;

public class Main {

    public static void main(String[] args) {

        // #1
        Animal gecko =  new Animal("reptiles");
        gecko.feed();
        gecko.takeForAWalk();
        gecko.takeForAWalk();
        gecko.takeForAWalk();
        gecko.takeForAWalk();
        gecko.takeForAWalk();
        gecko.takeForAWalk();
        gecko.takeForAWalk();
        gecko.takeForAWalk();
        gecko.feed();

        // #2
        Car fabia = new Car("Fabia", "Skoda");
        Human bob = new Human();
        bob.setCar(fabia);

    }
}

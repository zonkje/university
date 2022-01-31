package com.company;

import com.company.devices.Car;
import com.company.devices.Phone;

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
        bob.setSalary(3000.0);
        bob.getSalary();
        fabia.setValue(300.0);
        bob.setCar(fabia);

        // #6
        Car tiguan = new Car("Tiguan", "VolksWagen");
        Car anotherTiguan = new Car("Tiguan", "VolksWagen");
        System.out.println(tiguan.equals(anotherTiguan));
        System.out.println(tiguan);
        System.out.println(anotherTiguan);
        Phone iphone = new Phone("Iphone SE", "Apple");
        System.out.println(gecko);
        System.out.println(bob);
        System.out.println(iphone);

        // #7
        iphone.turnOn();
        fabia.turnOn();

    }
}

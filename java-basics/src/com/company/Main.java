package com.company;

import com.company.devices.Car;
import com.company.devices.Phone;

public class Main {

    public static void main(String[] args) {

        // #1
        Animal gecko = new Animal("reptiles");
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

        // #8
        bob.setPet(gecko);
        bob.setCash(1000.0);
        Human jon = new Human();
        jon.setCash(500.0);
        gecko.sell(bob, jon, 45.0);
        System.out.println(bob.getCash());
        System.out.println(bob.getPet());
        System.out.println(jon.getCash());
        System.out.println(jon.getPet());
        tiguan.setValue(80.0);
        bob.setCar(tiguan);
        jon.setSalary(2000.0);
        tiguan.sell(bob, jon, 100.0);
        bob.setPhone(iphone);
        iphone.sell(bob, jon, 30.0);

    }
}

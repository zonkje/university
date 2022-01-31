package com.company;

import com.company.creatures.Animal;
import com.company.creatures.FarmAnimal;
import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.devices.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // #1
        Animal gecko = new Pet("reptiles");
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
        Car fabia = new LPG("Fabia", "Skoda");
        Human bob = new Human();
        bob.setSalary(3000.0);
        bob.getSalary();
        fabia.setValue(300.0);
        bob.setCar(fabia, 0);

        // #6
        Car tiguan = new Diesel("Tiguan", "VolksWagen");
        Car anotherTiguan = new Diesel("Tiguan", "VolksWagen");
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
        bob.setCar(tiguan, 1);
        jon.setSalary(2000.0);
        tiguan.sell(bob, jon, 100.0);
        bob.setPhone(iphone);
        iphone.sell(bob, jon, 30.0);

        // #9
        FarmAnimal peppa = new FarmAnimal("mammals");
        peppa.beEaten();
        Animal ptysiek = new Pet("mammals");
        ptysiek.feed(8.0);
        System.out.println(ptysiek.getWeight());

        // #10
        iphone.installAnApp("Signal");
        List<String> appsToInstall = new ArrayList<>(){
            {
                add("LinkedIn");
                add("Bolt");
                add("Pinterest");
            }
        };
        iphone.installAnApp(appsToInstall);
        fabia.refuel();
        tiguan.refuel();
        Car tesla = new Electric("Model X", "Tesla");
        tesla.setYearOfProduction(2020);
        tesla.refuel();

        // #11
        Human fin = new Human();
        fin.setSalary(9999.0);
        tesla.setValue(369.0);
        fin.setCar(tesla, 0);
        System.out.println(fin.getCar(0));
        LPG golf = new LPG("Golf 2", "Volkswagen");
        golf.setYearOfProduction(1999);
        golf.setValue(111.0);
        fin.setCar(golf, 1);
        System.out.println(fin.getGarageValue());
        fin.sortCarsInGarageByYearOfProductionAsc();
        fin.printGarage();

        // #12
        System.out.println("Was jon an owner of tiguan? " + tiguan.hadAnOwner(jon));
        System.out.println("Whether the fabia was sold to jon by a bob? " + fabia.containsTransaction(jon, bob));
        System.out.println(tiguan.getNumberOfTransaction());


    }
}

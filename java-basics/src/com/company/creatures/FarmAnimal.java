package com.company.creatures;

public class FarmAnimal extends Animal implements Edible{

    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        System.out.println("Animal hsa been eaten");
        this.weight = 0.0;
    }
}
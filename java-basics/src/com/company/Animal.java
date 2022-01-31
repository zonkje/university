package com.company;

public class Animal {

    private final String species;
    private Double weight;

    public Animal(String species) {
        this.species = species;
        switch (species) {
            case "mammals":
                this.weight = 10.0;
                break;
            case "invertebrates":
                this.weight = 0.5;
                break;
            case "birds":
                this.weight = 6.0;
                break;
            case "amphibians":
                this.weight = 1.0;
                break;
            case "reptiles":
                this.weight = 2.0;
                break;
            case "fish":
                this.weight = 5.0;
                break;
            default:
                this.weight = 8.0;
                break;
        }
    }

    public void feed(){
        if(this.weight <= 0){
            System.out.println("Animal is dead");
            return;
        }
        this.weight += 0.5;
    }
    public void takeForAWalk(){
        if(this.weight <= 0){
            System.out.println("Animal is dead");
            return;
        }
        this. weight -= 0.4;
    }

}

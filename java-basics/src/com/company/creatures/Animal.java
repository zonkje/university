package com.company.creatures;

import com.company.Sellable;

public class Animal implements Sellable, Feedable {

    private final String species;
    Double weight;
    private Human owner;

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

    public Human getOwner() {
        return owner;
    }

    public Double getWeight() {
        return weight;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if(this instanceof Human){
            System.out.println("Human trafficking is not allowed");
            return;
        }
        if (!seller.getPet().equals(this)) {
            System.out.println("The seller is not the owner of this animal");
            return;
        } else if (!(buyer.getCash() > price)) {
            System.out.println("The buyer hasn't got enough money");
            return;
        }
        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);
        seller.setPet(null);
        buyer.setPet(this);
        System.out.println("Animal transaction successfully completed");
    }


    public void feed() {
        if (this.weight <= 0) {
            System.out.println("Animal is dead");
            return;
        }
        this.weight += 0.5;
    }

    @Override
    public void feed(Double foodWeight) {
        if(this.weight <= 0){
            System.out.println("Animal is dead");
            return;
        }
        this.weight += foodWeight*0.9;
    }

    public void takeForAWalk() {
        if (this.weight <= 0) {
            System.out.println("Animal is dead");
            return;
        }
        this.weight -= 0.4;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", weight=" + weight +
                '}';
    }

}

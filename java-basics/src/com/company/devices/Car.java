package com.company.devices;

import com.company.creatures.Human;
import com.company.Sellable;

public class Car extends Device implements Sellable {

    private String color;
    private boolean isSedan;
    private boolean hasManualGearbox;
    private Human owner;
    private Double value;

    public Car(String model, String producer) {
        super(model, producer);
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getModel() {
        return model;
    }

    @Override
    public void turnOn() {
        System.out.println(producer + " " + model + " has been started");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (!seller.getCar().equals(this)) {
            System.out.println("The seller is not the owner of this car");
            return;
        } else if (!(buyer.getCash() > price)) {
            System.out.println("The buyer hasn't got enough money");
            return;
        }
        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);
        seller.setUsedCar(null);
        buyer.setUsedCar(this);
        System.out.println("Car transaction successfully completed");
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", color='" + color + '\'' +
                ", isSedan=" + isSedan +
                ", hasManualGearbox=" + hasManualGearbox +
                ", yearOfProduction=" + yearOfProduction +
                ", owner=" + owner +
                ", value=" + value +
                '}';
    }
}
package com.company.devices;

import com.company.Human;

public class Car extends Device{

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
        System.out.println(producer+" "+model +" has been started");
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
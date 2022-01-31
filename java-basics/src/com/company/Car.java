package com.company;

public class Car {

    private final String model;
    private final String producer;
    private String color;
    private boolean isSedan;
    private boolean hasManualGearbox;
    private Integer yearOfProduction;
    private Human owner;
    private Double value;

    public Car(String model, String producer) {
        this.model = model;
        this.producer = producer;
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
}
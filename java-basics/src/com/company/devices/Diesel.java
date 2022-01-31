package com.company.devices;

public class Diesel extends Car{

    public Diesel(String model, String producer) {
        super(model, producer);
    }

    @Override
    public void refuel() {
        System.out.println("Refueling a diesel car");
    }
}
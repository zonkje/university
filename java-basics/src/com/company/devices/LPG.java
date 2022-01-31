package com.company.devices;

public class LPG extends Car{

    public LPG(String model, String producer) {
        super(model, producer);
    }

    @Override
    public void refuel() {
        System.out.println("Refueling a car with LPG");
    }
}
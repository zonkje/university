package com.company.devices;

public class Electric extends Car{

    public Electric(String model, String producer) {
        super(model, producer);
    }

    @Override
    public void refuel() {
        System.out.println("Electric car charging");
    }
}
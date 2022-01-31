package com.company.devices;

public class Phone extends Device{

    @Override
    public String toString() {
        return "Phone{}";
    }

    public Phone(String model, String producer) {
        super(model, producer);
    }

    @Override
    public void turnOn() {
        System.out.println(producer+" "+model +" has been turned on");
    }

}

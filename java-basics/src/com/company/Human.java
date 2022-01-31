package com.company;

public class Human extends Animal{

    private Animal pet;
    private Car car;

    public Human() {
        super("mammals");
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
        car.setOwner(this);
    }
}

package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Human extends Animal{

    private Animal pet;
    private Car car;
    private Double salary;

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
        if(salary > car.getValue()){
            System.out.println("The car has been purchased in cash");
        } else if (car.getValue()*12 > salary){
            System.out.println("The car was purchased on credit");
        } else {
            System.out.println("Get an education and get a new job or go for a raise");
            return;
        }
        this.car = car;
        car.setOwner(this);
    }

    public Double getSalary() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Checking salary. date: "+ formatter.format(date));
        System.out.println("Your salary is $"+salary);
        return salary;
    }

    public void setSalary(Double salary) {
        if(salary < 0){
            System.out.println("New salary must be non-negative");
            return;
        }
        System.out.println("New data has been sent to the accounting system");
        System.out.println("Go to the HR department and pick up the contract amendment from Mrs. Hania");
        System.out.println("We have sent information about your new salary to the ZUS and US");
        this.salary = salary;
    }
}

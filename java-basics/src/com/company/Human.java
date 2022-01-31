package com.company;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Human extends Animal {

    private Animal pet;
    private Car car;
    private Double salary;
    private Double cash;
    private Phone phone;

    public Human() {
        super("mammals");
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        if(pet instanceof Human){
            System.out.println("You can't have a man as a pet");
            return;
        }
        this.pet = pet;
        if (!(pet == null)) pet.setOwner(this);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if (salary > car.getValue()) {
            System.out.println("The car has been purchased in cash");
        } else if (car.getValue() * 12 > salary) {
            System.out.println("The car was purchased on credit");
        } else {
            System.out.println("Get an education and get a new job or go for a raise");
            return;
        }
        this.car = car;
        car.setOwner(this);
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        if (phone == null) {
            this.phone = null;
            return;
        }
        this.phone = phone;
        phone.setOwner(this);
    }

    public Double getSalary() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Checking salary. Date: " + formatter.format(date));
        System.out.println("Your salary is $" + salary);
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary < 0) {
            System.out.println("New salary must be non-negative");
            return;
        }
        System.out.println("New data has been sent to the accounting system");
        System.out.println("Go to the HR department and pick up the contract amendment from Mrs. Hania");
        System.out.println("We have sent information about your new salary to the ZUS and US");
        this.salary = salary;
    }

    public void setUsedCar(Car car) {
        if (car == null) {
            this.car = null;
            return;
        }
        this.car = car;
        car.setOwner(this);
    }


    @Override
    public String toString() {
        return "Human{" +
                "pet=" + pet +
                ", car=" + car.getModel() +
                ", salary=" + salary +
                '}';
    }
}

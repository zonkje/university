package com.company.creatures;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

public class Human extends Animal {

    private final int GARAGE_CAPACITY = 2;
    private Animal pet;
    private final Car[] garage;
    private Double salary;
    private Double cash;
    private Phone phone;

    public Human() {
        super("mammals");
        this.garage = new Car[GARAGE_CAPACITY];
    }

    public Human(int capacity) {
        super("mammals");
        this.garage = new Car[capacity];
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        if (pet instanceof Human) {
            System.out.println("You can't have a man as a pet");
            return;
        }
        this.pet = pet;
        if (!(pet == null)) pet.setOwner(this);
    }

    public Car getCar(int spotNumber) {
        return garage[spotNumber];
    }

    public void setCar(Car car, int spotNumber) {
        if (salary > car.getValue()) {
            System.out.println("The car has been purchased in cash");
        } else if (car.getValue() * 12 > salary) {
            System.out.println("The car was purchased on credit");
        } else if (spotNumber >= garage.length) {
            System.out.println("The garage is full");
            return;
        } else if (this.garage[spotNumber] != null){
            System.out.println("This spot in garage is taken");
            return;
        } else {
            System.out.println("Get an education and get a new job or go for a raise");
            return;
        }
        this.garage[spotNumber] = car;
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

    public void setUsedCar(Car car, int spotNumber) {
        if (car == null) {
            this.garage[spotNumber] = null;
            return;
        }
        this.garage[spotNumber] = car;
        car.setOwner(this);
    }

    public Double getGarageValue() {
        return Arrays.stream(garage).mapToDouble(Car::getValue).sum();
    }

    public void sortCarsInGarageByYearOfProductionAsc() {
        Arrays.stream(garage).sorted((o1, o2) -> o1.getYearOfProduction().compareTo(o2.getYearOfProduction())).collect(Collectors.toList());
    }

    public int findCarIndex(Car car) {
        for (int i = 0; i < garage.length; i++) {
            if (garage[i].equals(car)) {
                return i;
            }
        }
        return -1;
    }

    public int findFirstFreeSpotInGarage() {
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void printGarage(){
        for (Car car : garage) System.out.println(car);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Human{" + "pet=" + pet)
                .append(", garage= ");
        for (Car car : garage) {
            if (!(car == null)) {
                sb
                        .append(car.getModel())
                        .append(", ");
            }
        }
        sb.append(", salary=" + salary +
                '}');

        return sb.toString();
    }
}

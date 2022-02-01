package com.company.devices;

import com.company.model.InterruptedCarTransactionException;
import com.company.Sellable;
import com.company.model.Transaction;
import com.company.creatures.Human;

import java.util.LinkedList;

public abstract class Car extends Device implements Sellable {

    private String color;
    private boolean isSedan;
    private boolean hasManualGearbox;
    private Human owner;
    private Double value;
    private LinkedList<Transaction> transactions = new LinkedList<>();

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

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void turnOn() {
        System.out.println(producer + " " + model + " has been started");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        int spotNumberInSellersGarage = seller.findCarIndex(this);
        int firstFreeSpotNumberInBuyerGarage = buyer.findFirstFreeSpotInGarage();

        if (getNumberOfTransaction() > 0) {
            if (!this.transactions.getLast().getBuyer().equals(seller)) {
                throw new InterruptedCarTransactionException("The seller is not the owner of this car");
            }
        }
        if (!seller.getCar(spotNumberInSellersGarage).equals(this) || spotNumberInSellersGarage < 0) {
            throw new InterruptedCarTransactionException("The seller is not the owner of this car");
        } else if (!(buyer.getCash() > price)) {
            throw new InterruptedCarTransactionException("The buyer hasn't got enough money");
        } else if (firstFreeSpotNumberInBuyerGarage < 0) {
            throw new InterruptedCarTransactionException("The buyer hasn't got any free spot in his garage");
        }

        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);
        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);
        seller.setUsedCar(null, spotNumberInSellersGarage);
        buyer.setUsedCar(this, firstFreeSpotNumberInBuyerGarage);
        this.transactions.add(new Transaction(buyer, seller, price));
        System.out.println("Car transaction successfully completed");
    }

    public boolean hadAnOwner(Human human) {
        for (Transaction transaction : transactions) {
            if (transaction.getBuyer().equals(human) || transaction.getSeller().equals(human)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsTransaction(Human buyer, Human seller) {
        for (Transaction transaction : transactions) {
            if (transaction.getBuyer().equals(buyer) && transaction.getSeller().equals(seller)) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfTransaction() {
        return transactions.size();
    }

    public abstract void refuel();

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
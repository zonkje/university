package com.company.devices;

import com.company.creatures.Human;
import com.company.Sellable;

public class Phone extends Device implements Sellable {

    private Human owner;

    public Phone(String model, String producer) {
        super(model, producer);
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }


    @Override
    public void turnOn() {
        System.out.println(producer + " " + model + " has been turned on");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (!seller.getPhone().equals(this)) {
            System.out.println("The seller is not the owner of this phone");
            return;
        } else if (!(buyer.getCash() > price)) {
            System.out.println("The buyer hasn't got enough money");
            return;
        }
        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);
        seller.setPhone(null);
        buyer.setPhone(this);
        System.out.println("Phone transaction successfully completed");
    }


    @Override
    public String toString() {
        return "Phone{}";
    }
}

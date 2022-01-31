package com.company;

import com.company.creatures.Human;
import java.util.Date;

public class Transaction {

    private Human buyer;
    private Human seller;
    private Double price;
    private final Date date;

    public Transaction(Human buyer, Human seller, Double price) {
        this.buyer = buyer;
        this.seller = seller;
        this.price = price;
        this.date = new Date(System.currentTimeMillis());
    }

    public Human getBuyer() {
        return buyer;
    }

    public void setBuyer(Human buyer) {
        this.buyer = buyer;
    }

    public Human getSeller() {
        return seller;
    }

    public void setSeller(Human seller) {
        this.seller = seller;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }
}

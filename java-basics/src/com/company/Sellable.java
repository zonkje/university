package com.company;

import com.company.creatures.Human;

public interface Sellable {

    public void sell(Human seller, Human buyer, Double price);

}
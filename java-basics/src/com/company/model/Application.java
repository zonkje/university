package com.company.model;

public class Application {

    private String name;
    private String version;
    private Double price;

    public Application(String name, String version, Double price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void showInfo(){
        System.out.println("Application name: "+this.name+", version: "+this.version+", price: $"+this.price);

    }

}

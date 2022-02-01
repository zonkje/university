package com.company.devices;

import com.company.Sellable;
import com.company.creatures.Human;
import com.company.model.Application;

import java.net.URL;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Phone extends Device implements Sellable {

    private final static String DEFAULT_SERVER_ADDRESS = "www.apple.com/store";
    private final static String DEFAULT_PROTOCOL = "https";
    private final static String DEFAULT_VERSION = "1.0";

    private Human owner;
    private Set<Application> apps = new HashSet<>();

    public Phone(String model, String producer) {
        super(model, producer);
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    public void installAnApp(String appName) {
        installAnApp(appName, DEFAULT_VERSION, DEFAULT_SERVER_ADDRESS);
    }

    public void installAnApp(String appName, String appVersion) {
        installAnApp(appName, appVersion, DEFAULT_SERVER_ADDRESS);
    }

    public void installAnApp(String appName, String appVersion, String serverAddress) {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Downloading and installing application ")
                .append(appName + "\n")
                .append(". . .\n")
                .append("version: ")
                .append(appVersion + "\n")
                .append(". . .\n")
                .append("Downloading from ")
                .append(DEFAULT_PROTOCOL)
                .append("://")
                .append(serverAddress + "\n")
                .append(". . .\n")
                .append("Downloaded. Installing... \n")
                .append(". . .\n")
                .append("The application has been successfully installed on your phone");
        System.out.println(sb.toString());

    }

    public void installAnApp(List<String> appNames) {
        for (String name : appNames) {
            installAnApp(name);
        }
    }

    public void installAnApp(URL appUrl) {
        System.out.println("WARNING: Make sure this URL is save!");
        System.out.println("Downloading application from address: " + appUrl.toString());
        System.out.println(". . .");
        System.out.println("Downloaded. Installing...");
        System.out.println(". . .");
        System.out.println("The application has been successfully installed on your phone");
    }

    public void installAnApp(Application... applications){
        for(Application application : applications) {
            if (owner.getCash() >= application.getPrice()) {
                apps.add(application);
                owner.setCash(owner.getCash() - application.getPrice());
                System.out.println("Application "+application.getName()+" been successfully installed on your phone");
            } else {
                System.out.println("You don't have enough funds to complete this transaction");
            }
        }
    }

    public boolean isApplicationInstalled(Application app){
        return apps.contains(app);
    }

    public boolean isApplicationInstalled(String appName){
        return apps.stream().anyMatch(app -> appName.equals(app.getName()));
    }

    public void displayAllFreeApps(){
        apps.stream()
                .filter(app -> app.getPrice() == 0.0)
                .forEach(Application::showInfo);
    }

    public Double getValueOfInstalledApps(){
        return apps.stream()
                .mapToDouble(Application::getPrice)
                .sum();
    }

    public void displayAllInstalledAppsInAlphabeticalOrder(){
        apps.stream()
                .sorted(Comparator.comparing(Application::getName))
                .forEach(Application::showInfo);
    }

    public void displayAllInstalledAppsByPriceAscending(){
        apps.stream()
                .sorted(Comparator.comparingDouble(Application::getPrice))
                .forEach(Application::showInfo);
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
        return "Phone{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", value=" + value +
                '}';
    }
}

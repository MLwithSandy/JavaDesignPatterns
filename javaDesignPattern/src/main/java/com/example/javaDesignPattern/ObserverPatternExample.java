package com.example.javaDesignPattern;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void register(Observer obj);
    void unRegister(Observer obj);
    void notifyAllObservers();
}

class DeliveryData implements Subject{
    private String location;
    private List<Observer> listOfObserver;


    public DeliveryData() {
        listOfObserver = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer obj){
        this.listOfObserver.add(obj);
    }
    @Override
    public void unRegister(Observer obj){
        this.listOfObserver.remove(obj);
    }

    @Override
    public void notifyAllObservers(){
        for(Observer obj: listOfObserver){
            obj.update(location);
        }
    }

    public void locationChanged(){
        this.location = getLocation();
        notifyAllObservers();
    }

    private String getLocation(){
        return "XYZ";
    }
}


interface Observer{
    void update(String location);
}

class User implements Observer{
    private String location;

    @Override
    public void update(String location){
        this.location = location;
        this.showLocation();

    }

    public void showLocation(){
        System.out.println("User observed location change to " + this.location);
    }
}

class Seller implements Observer{
    private String location;

    @Override
    public void update(String location){
        this.location = location;
        this.showLocation();

    }

    public void showLocation(){
        System.out.println("Seller observed location change to " + this.location);
    }
}

class Warehouse implements Observer{
    private String location;

    @Override
    public void update(String location){
        this.location = location;
        this.showLocation();
    }

    public void showLocation(){
        System.out.println("Warehouse observed location change to " + this.location);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new Warehouse();

        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        topic.locationChanged();

        topic.unRegister(obj2);
        topic.locationChanged();

    }
}

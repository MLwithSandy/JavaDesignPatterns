package com.example.javaDesignPattern;

import java.util.ArrayList;
import java.util.List;

class Vehicle2 implements Cloneable{
    private List<String> vehicleList;

    public Vehicle2() {
        this.vehicleList = new ArrayList<String>();
    }

    public Vehicle2(List<String> vehicleList) {
        this.vehicleList = vehicleList;
    }
    public List<String> getVehicleList() {
        return vehicleList;
    }
    public void addVehicle(){
        this.vehicleList.add("abcd");
        this.vehicleList.add("efgh");
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> tempList = new ArrayList<String>();
        for (String s: this.getVehicleList()){
            tempList.add(s);
        }
        return new Vehicle2(tempList);
    }

}

public class PrototypePatternExample {
    public static void main(String[] args) throws CloneNotSupportedException{
        Vehicle2 a = new Vehicle2();
        a.addVehicle();

        Vehicle2 b = (Vehicle2) a.clone();
        for (String S: b.getVehicleList()){
            System.out.println(S);
        }

    }
}

package com.example.javaDesignPattern;

class Vehicle1{
    //mandatory parameter
    private int engine;
    private int wheel;

    //optional parameter
    private int airbags;

    public int getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getAirbags() {
        return airbags;
    }


    private Vehicle1(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    public static class VehicleBuilder{


        //mandatory parameter
        private int engine;
        private int wheel;

        //optional parameter
        private int airbags;

        public VehicleBuilder(int engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle1 build(){
            return new Vehicle1(this);
        }

    }
}


public class BuilderPatternExample {
    public static void main(String[] args) {
        Vehicle1 car = new Vehicle1.VehicleBuilder(1200, 4).setAirbags(4).build();
        Vehicle1 bike = new Vehicle1.VehicleBuilder(200,2).build();
        System.out.println(car.getWheel() + " " + car.getAirbags());
        System.out.println(bike.getWheel() + " " + bike.getAirbags());
    }

}

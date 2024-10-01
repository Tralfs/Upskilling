package org.java.Patterns.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        Logistics logistics;

        logistics = new RoadLogistics();
        logistics.planDelivery();  // Output: Delivering by Truck

        logistics = new SeaLogistics();
        logistics.planDelivery();  // Output: Delivering by Ship
    }
}
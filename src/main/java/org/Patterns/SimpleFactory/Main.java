package org.Patterns.SimpleFactory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle vehicle1 = factory.createVehicle("car");
        vehicle1.deliver();  // Output: Delivering by Car

        Vehicle vehicle2 = factory.createVehicle("bike");
        vehicle2.deliver();  // Output: Delivering by Bike

        Vehicle vehicle3 = factory.createVehicle("truck");
        vehicle3.deliver();  // Output: Delivering by Truck
    }
}

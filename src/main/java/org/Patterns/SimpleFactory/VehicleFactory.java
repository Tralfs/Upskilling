package org.Patterns.SimpleFactory;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
package org.java.Patterns.Builder;

public class Car {
    // Required parameters
    private final String model;
    private final String manufacturer;

    // Optional parameters
    private final String color;
    private final String engineType;
    private final int doors;

    // Private constructor accessed only by the Builder
    private Car(Builder builder) {
        this.model = builder.model;
        this.manufacturer = builder.manufacturer;
        this.color = builder.color;
        this.engineType = builder.engineType;
        this.doors = builder.doors;
    }

    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private final String model;
        private final String manufacturer;

        // Optional parameters with default values
        private String color = "White";
        private String engineType = "Petrol";
        private int doors = 4;

        // Constructor for required parameters
        public Builder(String model, String manufacturer) {
            this.model = model;
            this.manufacturer = manufacturer;
        }

        // Methods for optional parameters, returning Builder for chaining
        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder engineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public Builder doors(int doors) {
            this.doors = doors;
            return this;
        }

        // Build method to create the final Car object
        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", manufacturer=" + manufacturer +
                ", color=" + color + ", engineType=" + engineType +
                ", doors=" + doors + "]";
    }

    // Example usage of Builder Pattern
    public static void main(String[] args) {
        Car car = new Car.Builder("Model S", "Tesla")
                .color("Red")
                .engineType("Electric")
                .doors(2)
                .build();

        System.out.println(car);
    }
}
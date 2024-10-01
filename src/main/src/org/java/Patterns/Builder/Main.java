package org.java.Patterns.Builder;

public class Main {
    public static void main(String[] args) {
        Car car = new Car.Builder("Model S", "Tesla")
                .color("Red")
                .engineType("Electric")
                .doors(2)
                .build();
    }
}

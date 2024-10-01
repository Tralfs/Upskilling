package org.java.Patterns.SimpleFactory;

public class Truck implements Vehicle{
    @Override
    public void deliver() {
        System.out.println("Delivering by Truck");
    }
}

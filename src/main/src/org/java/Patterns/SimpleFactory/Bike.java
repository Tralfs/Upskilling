package org.java.Patterns.SimpleFactory;

public class Bike implements Vehicle{
    @Override
    public void deliver() {
        System.out.println("Delivering by Bike");
    }
}

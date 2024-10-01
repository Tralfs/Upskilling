package org.java.Patterns.SimpleFactory;

public class Car implements Vehicle{
    @Override
    public void deliver() {
        System.out.println("Delivering by Car");
    }
}

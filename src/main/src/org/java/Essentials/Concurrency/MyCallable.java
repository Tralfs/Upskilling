package org.java.Essentials.Concurrency;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private final int number;

    public MyCallable(int number) {
        this.number = number;
    }

    @Override
    public Integer call(){
        System.out.println("Processing number: " + number + " in thread: " + Thread.currentThread().getName());
        // Perform some operation using the parameter
        return number * 2;
    }
}
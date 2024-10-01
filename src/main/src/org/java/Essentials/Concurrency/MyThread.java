package org.java.Essentials.Concurrency;

public class MyThread extends Thread {
    private final String threadName;

    MyThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(1000); // Pauses execution for 1 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(threadName + " has finished execution.");
    }
}
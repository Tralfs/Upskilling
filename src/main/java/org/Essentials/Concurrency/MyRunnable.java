package org.Essentials.Concurrency;

public class MyRunnable implements Runnable {
    private String threadName;

    MyRunnable(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(1000); // Pauses execution for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(threadName + " has finished execution.");
    }
}
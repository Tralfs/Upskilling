package org.Essentials.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        simpleThreading();
        simpleExecuter();
    }

    private static void simpleExecuter(){
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the executor
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println("Thread: " + Thread.currentThread().getName());
            });
        }

        // Shutdown the executor to free resources
        executor.shutdown();
    }

    private static void simpleThreading(){
        MyThread t1 = new MyThread("Thread 1");
        MyThread t2 = new MyThread("Thread 2");
        Thread lambdaThreadt = new Thread(()-> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Lambda Thread: " + i);
                try {
                    Thread.sleep(1000); // Pauses execution for 1 second
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });

        MyRunnable r1 = new MyRunnable("RunnableThread 1");
        MyRunnable r2 = new MyRunnable("RunnableThread 2");

        Thread rT1 = new Thread(r1);
        Thread rT2 = new Thread(r2);

        t1.start(); // Start the first thread
        t2.start(); // Start the second thread
        lambdaThreadt.start(); // Start the third thread

        rT1.start(); // Start the first RunnableThread
        rT2.start(); // Start the second RunnableThread

        try {
            t1.join();
            t2.join();
            lambdaThreadt.join();
            rT1.join();
            rT2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



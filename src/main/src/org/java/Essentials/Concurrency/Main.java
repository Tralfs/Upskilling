package org.java.Essentials.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("____________simpleThreading____________");
        simpleThreading();
        System.out.println("____________simpleExecuter____________");
        simpleExecuter();
        System.out.println("____________executerWithCallable____________");
        executerWithCallable();
        System.out.println("____________executerWithCustomCallable____________");
        executerWithCustomCallable();
    }

    private static void simpleThreading(){
        MyThread t1 = new MyThread("Thread 1");
        MyThread t2 = new MyThread("Thread 2");
        Thread lambdaThread = new Thread(()-> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Lambda Thread: " + i);
                try {
                    Thread.sleep(1000); // Pauses execution for 1 second
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        MyRunnable r1 = new MyRunnable("RunnableThread 1");
        MyRunnable r2 = new MyRunnable("RunnableThread 2");

        Thread rT1 = new Thread(r1);
        Thread rT2 = new Thread(r2);

        t1.start(); // Start the first thread
        t2.start(); // Start the second thread
        lambdaThread.start(); // Start the third thread

        rT1.start(); // Start the first RunnableThread
        rT2.start(); // Start the second RunnableThread

        try {
            t1.join();
            t2.join();
            lambdaThread.join();
            rT1.join();
            rT2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void simpleExecuter(){
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the executor
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> System.out.println("Thread: " + Thread.currentThread().getName()));
        }

        // Shutdown the executor to free resources, the main thread will continue
        executor.shutdown();
        // Wait for all tasks to complete (up to 10 seconds)
        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("All tasks completed.");
            } else {
                System.out.println("Timeout occurred before tasks were finished.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executerWithCallable() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            System.out.println("Executing task in thread: " + Thread.currentThread().getName());
            return 42;
        };

        // Submit task and get the result in a Future
        Future<Integer> future = executorService.submit(task);

        // Get the result of the task
        Integer result;
        try {
            result = future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Result: " + result);

        executorService.shutdown();
    }

    public static void executerWithCustomCallable(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit a Callable with a parameter and get the result in a Future
        List<Future<Integer>> futureList = new ArrayList<>();
        futureList.add(executorService.submit(new MyCallable(5)));
        // Submit tasks to the executor
        for (int i = 0; i < 5; i++) {
            futureList.add(executorService.submit(new MyCallable(i)));
        }
        futureList.forEach(s-> {
            try {
                System.out.println(s.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();
    }
}
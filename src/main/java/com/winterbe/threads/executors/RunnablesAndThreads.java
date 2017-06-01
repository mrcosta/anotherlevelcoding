package com.winterbe.threads.executors;

public class RunnablesAndThreads {

    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");

//      Due to concurrent execution we cannot predict if the runnable will be invoked before or after printing 'done'.
//      The order is non-deterministic, thus making concurrent programming a complex task in larger applications.
    }
}

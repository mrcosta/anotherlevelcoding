package com.winterbe.threads.executors;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class ExecutorsExample {

    public static void main(String[] args) {
        ExecutorService executor = newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        executor.shutdown();

//        The result looks similar to the above sample but when running the code you'll notice an important difference: the java process never stops!
// Executors have to be stopped explicitly - otherwise they keep listening for new tasks.
    }

//    try {
//        System.out.println("attempt to shutdown executor");
//        executor.shutdown();
//        executor.awaitTermination(5, TimeUnit.SECONDS);
//    }
//catch (InterruptedException e) {
//        System.err.println("tasks interrupted");
//    }
//finally {
//        if (!executor.isTerminated()) {
//            System.err.println("cancel non-finished tasks");
//        }
//        executor.shutdownNow();
//        System.out.println("shutdown finished");
//    }
}

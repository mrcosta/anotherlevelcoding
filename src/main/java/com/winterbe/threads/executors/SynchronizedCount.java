package com.winterbe.threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizedCount {

    int count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        SynchronizedCount synchronizedCount = new SynchronizedCount();

        IntStream.range(0, 10000).forEach(i -> executorService.submit(synchronizedCount::increment));

        stop(executorService);

        System.out.println(synchronizedCount.count);  // 9965
        // Instead of seeing a constant result count of 10000 the actual result varies with every execution of the above code.
        // The reason is that we share a mutable variable upon different threads without synchronizing the access to this variable which results in a race condition.
    }

    synchronized void incrementSync() { // this work better
        count = count + 1;
    }

//    void incrementSync() {
//        synchronized (this) {
//            count = count + 1;
//        }
//    } // this also works

//    The class ReentrantLock is a mutual exclusion lock with the same basic behavior as the implicit monitors accessed via the synchronized keyword but with extended capabilities

    void increment() {
        count = count + 1;
    }

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}

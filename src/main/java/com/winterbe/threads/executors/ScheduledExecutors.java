package com.winterbe.threads.executors;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.Executors.newScheduledThreadPool;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ScheduledExecutors {

    public static void main(String[] args) throws InterruptedException {
        //A ScheduledExecutorService is capable of scheduling tasks to run either periodically or once after a certain amount of time has elapsed.
        //This code sample schedules a task to run after an initial delay of three seconds has passed:
        ScheduledExecutorService executor = newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3, SECONDS);

        MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(MILLISECONDS); // getDelay() to retrieve the remaining delay. After this delay has elapsed the task will be executed concurrently.
        System.out.printf("Remaining Delay: %sms", remainingDelay);

        // also we have scheduleAtFixedRate()
        // also we have scheduleWithFixedDelay()
    }
}

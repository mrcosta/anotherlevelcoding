package com.winterbe.threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import static com.winterbe.threads.executors.SynchronizedCount.stop;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.stream.IntStream.range;

public class Atomic {

    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = newFixedThreadPool(2);

        range(0, 1000).forEach(i -> executor.submit(atomicInt::incrementAndGet));

        stop(executor);
        System.out.println(atomicInt.get());    // => 1000
    }
}

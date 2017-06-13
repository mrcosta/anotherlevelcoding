package com.winterbe.threads.executors;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
//      The interface ReadWriteLock specifies another type of lock maintaining a pair of locks for read and write access.
//      The idea behind read-write locks is that it's usually safe to read mutable variables concurrently as long as nobody is writing to this variable.
//      So the read-lock can be held simultaneously by multiple threads as long as no threads hold the write-lock.
//      This can improve performance and throughput in case that reads are more frequent than writes.
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        executor.submit(() -> {
            lock.writeLock().lock();
            try {
                new SynchronizedCount().sleep(1);
                map.put("foo", "bar");
            } finally {
                lock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {
            lock.readLock().lock();
            try {
                System.out.println(map.get("foo"));
                new SynchronizedCount().sleep(1);
            } finally {
                lock.readLock().unlock();
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        new SynchronizedCount().stop(executor);
    }
}

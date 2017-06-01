package com.winterbe.threads.executors;

import java.util.List;
import java.util.concurrent.*;

import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;

public class CallablesAndFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<Integer> task = () -> {
            try {
                SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        Integer result = future.get();
        future.get(1, TimeUnit.SECONDS); // or adding a second parameter to wait just these seconds
        //Calling the method get() blocks the current thread and waits until the callable completes before
        // returning the actual result 123. Now the future is finally done and we see the following result on the console:

        System.out.println("future done? " + future.isDone());
        System.out.println("result: " + result);

        // to call multiple callables
        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> callables = asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        executorService.invokeAll(callables)
                .stream()
                .map(response -> {
                    try {
                        return response.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);

        //InvokeAny
        //Another way of batch-submitting callables is the method invokeAny() which works slightly different to invokeAll().
        // Instead of returning future objects this method blocks until the first callable terminates and returns the result
        // of that callable.

    }
}

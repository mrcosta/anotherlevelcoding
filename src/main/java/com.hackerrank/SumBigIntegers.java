package com.hackerrank;

public class SumBigIntegers {

    public Long sumBigIntegers(Integer amount, Integer... toBeSum) {
        Long sum = 0L;
        for (int i = 0; i < amount; i++) {
           sum+= toBeSum[i];
        }

        return sum;
    }
}

package com.hackerrank.crackingthecodinginterview;

import java.util.List;
import java.util.stream.Collectors;

public class ArrayLeftRotation {

    public String modifyArray(int rotationsNumber, List<Integer> array) {
        for (int i = 0; i < rotationsNumber; i++) {
            Integer firstValue = array.remove(0);
            array.add(firstValue);
        }

        return array.stream().map(i -> i.toString()).collect(Collectors.joining(" "));
    }
}

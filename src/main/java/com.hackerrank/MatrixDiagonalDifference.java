package com.hackerrank;

import java.util.List;
import java.util.Scanner;

public class MatrixDiagonalDifference {

    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public int getAbsoluteDifference(int amount, int[][] matrix) {
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        int count = 0;

        while (count < amount) {
           firstDiagonal+= matrix[count][count];
           secondDiagonal+= matrix[count][amount - (count + 1)];
           count++;
        }

        return Math.abs(firstDiagonal - secondDiagonal);
    }
}

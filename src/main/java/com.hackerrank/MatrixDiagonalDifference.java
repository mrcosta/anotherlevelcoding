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

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        int[][] matrix = new int[amount][amount];

        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < amount; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        System.out.println(Math.abs(new MatrixDiagonalDifference().getAbsoluteDifference(amount, matrix)));
    }
}
